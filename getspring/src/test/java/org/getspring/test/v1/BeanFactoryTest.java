package org.getspring.test.v1;

import static org.junit.Assert.assertNotNull;

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
		PetStoreService petStore = (PetStoreService) beanFactory.getBean("petstore");
		assertNotNull(petStore);
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
		//修改了一个功能
		Assert.fail("expect BeanDefinitionStoreException");
	}
}
