package com.bjy.lotus;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.bjy.lotus.domain.Student;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

//@RunWith(SpringJUnit4ClassRunner.class)
public class JacksonTest {

	@Test
	public void testWrite() throws JsonGenerationException, JsonMappingException, IOException {
		// 创建ObjectMapper对象，并置置json处理的一些特性
		ObjectMapper objectMapper = new ObjectMapper();

		// 序列化时设置缩进，便于阅读
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		// 序列化时让map的key自然排列
		objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

		// 设置日期格式，
		objectMapper.setDateFormat(new SimpleDateFormat("yyyyMMdd HHmmss"));

		// 设置序列化时，属性没有值时是否可以忽略，默认Json是会处理的，如int型为0，String为null，数组为[]
		// objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

		Student student = new Student(1, "张三", 22, new Date(), 50.12, new Timestamp(System.currentTimeMillis()));

		// 序列化pojo对象到某一个输出流中
		objectMapper.writeValue(System.out, student);

	}

	@Test
	public void testRead() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();

		// 忽略位置属性，json串中有的，但是POJO中没有的属性，否则反序列化时会失败
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		// 设置日期格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

		Resource resource = new ClassPathResource("data.json");
		Student student = objectMapper.readValue(resource.getInputStream(), Student.class);
		System.out.println(student);

	}

	@Test
	public void testTreeModelWrite() throws IOException {
		// 创建生成json节点的工厂对象
		JsonNodeFactory nodeFactory = new JsonNodeFactory(false);

		/**
		 * 创建json节点
		 */
		// 创建根节点
		ObjectNode root = nodeFactory.objectNode();
		root.put("id", 1);
		root.put("name", "张三");
		root.put("sex", "WOMAN");
		root.put("birthday", "2012-12-12 12:12:12");

		// 添加数组节点
		ArrayNode enjoyes = nodeFactory.arrayNode();
		enjoyes.add("篮球").add("足球").add("羽毛球");
		root.set("enjoyes", enjoyes);

		// 添加数据节点
		ArrayNode cources = nodeFactory.arrayNode();
		ObjectNode cource1 = nodeFactory.objectNode();
		cource1.put("id", 1);
		cource1.put("name", "语文");

		ObjectNode cource2 = nodeFactory.objectNode();
		cource2.put("id", 1);
		cource2.put("name", "数学");
		cources.add(cource1).add(cource2);
		root.set("cources", cources);

		// 输出json字符串
		ObjectMapper objectMapper = new ObjectMapper();
		JsonGenerator generator = objectMapper.getFactory().createGenerator(System.out);
		objectMapper.writeTree(generator, root);

	}

	@Test
	public void testTreeModeRead() throws JsonProcessingException, IOException{
		 ObjectMapper mapper = new ObjectMapper();  
	     // 读取json，将整个json作为根节点  
		 Resource resource=new ClassPathResource("data.json");
		 JsonNode node = mapper.readTree(resource.getInputStream());
		
		 // 看看根节点的类型  
		 System.out.println("node JsonNodeType:" + node.getNodeType());//OBJECT  
		 // 是不是一个ContainerNode（array and object nodes）  
		 System.out.println("node is containerNode ? " + node.isContainerNode());//true  
		 // 得到所有node节点的直接子节点名称  
		 Iterator<String> fieldNames = node.fieldNames();  
		 while (fieldNames.hasNext()) {  
			 String fieldName = fieldNames.next();  
			 System.out.println(fieldName + " ");//root children  
		 }  
		 System.out.println(node.get("root").isContainerNode());//false 
	}
}
