package org.getspring.test.v2;

import static org.junit.Assert.assertNotNull;

import org.getspring.beans.factory.context.ApplicationContext;
import org.getspring.beans.factory.context.support.ClassPathXmlApplicationContext;
import org.getspring.beans.factory.context.support.FileSystemXmlApplicationContext;
import org.getspring.service.v1.PetStoreService;
import org.junit.Test;

public class ApplicationContextTestV2 {

	@Test
	public void testGetBean() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("petstore-v2.xml");
		PetStoreService petStore = (PetStoreService) ctx.getBean("petstore");
		assertNotNull(petStore);
	}
}
