package org.getspring.test.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanFactory;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.service.v1.PetStoreService;
import org.junit.Test;

public class BeanFactoryTest {

	@Test
	public void testGetBean() {
		BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = beanFactory.getBeanDefinition("petStore");
		assertEquals("org.getspring.service.v1.PetStoreSerivce", bd.getBeanClassName());
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petStore");
		assertNotNull(petStore);
	}

}
