package org.getspring.test.v2;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.getspring.core.io.ClassPathResource;
import org.junit.Test;

public class BeanDefinitionTestV2 {

	@Test
	public void testGetBeanDefinition() {
		DefaultBeanFactory factory=new DefaultBeanFactory();
		XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinition(new ClassPathResource("petstore-v2.xml"));
		BeanDefinition bd =factory.getBeanDefinition("petstore");
		
		
	}

}
