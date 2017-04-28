package com.bjy.lotus;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bjy.lotus.domain.DependsOnExoticType;
import com.bjy.lotus.domain.Foo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfiguration.class})
@ActiveProfiles("test")
public class AppTest {
	
	@Autowired
	private Foo foo;
	
	@Autowired
	private DependsOnExoticType dependsOnExoticType;
	
	@Test
	public void testPersonEditor(){
		System.out.println(foo.toString());
		System.out.println(dependsOnExoticType.getType().getName());
	}
}
