package org.getspring.test.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.BeanFactory;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {

	@Test
	public void testGetBean() {
		BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = beanFactory.getBeanDefinition("petstore");
		assertEquals("org.getspring.service.v1.PetStoreService", bd.getBeanClassName());
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petstore");
		assertNotNull(petStore);
	}
	
	@Test
	public void testInvalidBean() {
		BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");
		try {
			beanFactory.getBean("invalidBean");
		} catch (BeanCreationException e) {
			return ;
		}
		
		Assert.fail("expect BeanCreationException");
	}

	@Test
	public void testInvalidXML() {
		
		try {
			BeanFactory beanFactory = new DefaultBeanFactory("xxx.xml");
		} catch (BeanDefinitionStoreException e) {
			return ;
		}
		
		Assert.fail("expect BeanDefinitionStoreException");
	}
}
