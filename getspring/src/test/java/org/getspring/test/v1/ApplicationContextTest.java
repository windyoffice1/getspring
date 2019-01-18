package org.getspring.test.v1;

import static org.junit.Assert.assertNotNull;

import org.getspring.beans.factory.context.ApplicationContext;
import org.getspring.beans.factory.context.support.ClassPathXmlApplicationContext;
import org.getspring.beans.factory.context.support.FileSystemXmlApplicationContext;
import org.getspring.service.v1.PetStoreService;
import org.junit.Test;

public class ApplicationContextTest {

	@Test
	public void testGetBean() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v1.xml");
		PetStoreService petStore = (PetStoreService) ctx.getBean("petstore");
		assertNotNull(petStore);
	}
	
	@Test
	public void testGetBeanFromFileSystemContext() {
		ApplicationContext ctx=new FileSystemXmlApplicationContext("C:\\git-workspace\\getspring\\getspring\\src\\test\\resources\\petstore-v1.xml");
		PetStoreService petStore = (PetStoreService) ctx.getBean("petstore");
		assertNotNull(petStore);
	}

}
