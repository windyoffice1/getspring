package org.getspring.test.v1;

import static org.junit.Assert.assertNotNull;

import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.getspring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeanFactoryTest {
	
	DefaultBeanFactory beanFactory=null;
	XmlBeanDefinitionReader reader=null;
	
	@Before
	public void setUp() {
		beanFactory = new DefaultBeanFactory();
		reader=new XmlBeanDefinitionReader(beanFactory);
	}

	@Test
	public void testGetBean() {
		reader.loadBeanDefinition("petstore-v1.xml");
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petstore");
		assertNotNull(petStore);
	}
	
	@Test
	public void testInvalidBean() {
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
			reader.loadBeanDefinition("xxxx.xml");
		} catch (BeanDefinitionStoreException e) {
			return ;
		}
		
		Assert.fail("expect BeanDefinitionStoreException");
	}
}
