package org.getspring.test.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.getspring.core.io.ClassPathResource;
import org.getspring.core.io.Resource;
import org.getspring.service.v1.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeanFactoryTest {
	
	DefaultBeanFactory beanFactory=null;
	XmlBeanDefinitionReader reader=null;
	Resource resource=null;
	
	@Before
	public void setUp() {
		beanFactory = new DefaultBeanFactory();
		reader=new XmlBeanDefinitionReader(beanFactory);
		resource=new ClassPathResource("petstore-v1.xml");
	}

	@Test
	public void testGetBean() {
		reader.loadBeanDefinition(resource);
		BeanDefinition bd=beanFactory.getBeanDefinition("petstore");
		assertTrue(bd.isSingleton());
		assertFalse(bd.isPrototype());
		assertEquals(BeanDefinition.SCOPE_DEFAULT, bd.getScope());
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petstore");
		PetStoreService petStore1 = (PetStoreService) beanFactory.getBean("petstore");

		assertNotNull(petStore);
		assertTrue(petStore.equals(petStore1));
	}
	
	@Test
	public void testInvalidBean() {
		reader.loadBeanDefinition(resource);
		try {
			beanFactory.getBean("invalidBean");
		} catch (BeanCreationException e) {
			return ;
		}
		
		Assert.fail("expect BeanCreationException");
	}

	@Test
	public void testInvalidXML() {
		resource=new ClassPathResource("xxxx.xml");
		try {
			reader.loadBeanDefinition(resource);
		} catch (BeanDefinitionStoreException e) {
			return ;
		}
		
		Assert.fail("expect BeanDefinitionStoreException");
	}
}
