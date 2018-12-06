package org.getspring.test.v1;

import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactoryTest {

	@Test
	public void testGetBean() {
/*		BeanFactory beanFactory = new DefaultBeanFactory("petstore-v1.xml");
		BeanDefinition bd = beanFactory.getBeanDefinition("petstore");
		assertEquals("org.getspring.service.v1.PetStoreService", bd.getBeanClassName());
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petstore");
		assertNotNull(petStore);*/
		DefaultBeanFactory beanFactory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinition("petstore-v1.xml");
	}
	
	@Test
	public void testInvalidBean() {
		DefaultBeanFactory beanFactory = new DefaultBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
		reader.loadBeanDefinition("petstore-v1.xml");
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
			DefaultBeanFactory beanFactory = new DefaultBeanFactory();
			XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(beanFactory);
			reader.loadBeanDefinition("xxxx.xml");
		} catch (BeanDefinitionStoreException e) {
			return ;
		}
		
		Assert.fail("expect BeanDefinitionStoreException");
	}
}
