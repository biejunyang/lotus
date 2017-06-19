package com.bjy.lotus.common.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

import com.bjy.lotus.common.enums.OSTypeEnum;
import com.bjy.lotus.common.utils.StringUtil;


public class SystemContext {

	private final static Log log4j = LogFactory.getLog(SystemContext.class);
	
	private static ApplicationContext applicationContext;
	
	private static ServletContext servletContext;
	
	private static Map<String, String> systemInfo=new HashMap<String, String>();
	
	private static File tempDir;//文件操作临时目录
	
	private static Properties VMProperties = System.getProperties();
	
	private static OSTypeEnum osType;//部署的服务器的操作系统
	
	static{
		try
		{
			init();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			log4j.error("系统初始化失败！");
		}
	}
	
	private static void init() throws IOException{
		//系统配置文件读取
		Properties sysProps=new Properties();
		InputStream sysIn=Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
		sysProps.load(sysIn);
		for(Map.Entry<Object, Object> en: sysProps.entrySet()){
			systemInfo.put(String.valueOf(en.getKey()), String.valueOf(en.getValue()));
		}
		
		//部署操作系统类型
		String osName = VMProperties.getProperty("os.name");
		if(osName.toUpperCase().indexOf("WINDOWS")>-1){
			osType=OSTypeEnum.WINDOWS;
		}else{
			osType=OSTypeEnum.LINUX;
		}
		
		//系统文件操作目录
		String basePath=systemInfo.get("system.file.dir");
		tempDir=createTempDir(basePath);
		
	}

	public static <T> T getBean(String name, Class<? extends T> clazz){
		return applicationContext.getBean(name, clazz);
	}
	
	public static <T> T getBean(Class<? extends T> clazz){
		return applicationContext.getBean(clazz);
	}
	
	public static String getSystemInfo(String key){
		return systemInfo.get(key);
	}
	
	public static ServletContext getSrevletContext(){
		return servletContext;
	}
	
	public static OSTypeEnum getOSType(){
		return osType;
	}
	
	public static File getTempDir(){
		return tempDir;
	}
	
	private static File createTempDir(String path){
		if(StringUtil.isNotNull(path)){
			File dir=new File(path);
			if(!dir.exists()){
				dir.mkdirs();
			}
			return dir;
		}else{
			throw new RuntimeException("请设置系统文件操作目录!");
		}
	}
	
}
