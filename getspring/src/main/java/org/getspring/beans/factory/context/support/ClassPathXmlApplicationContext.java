package org.getspring.beans.factory.context.support;

import org.getspring.beans.factory.context.ApplicationContext;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext implements ApplicationContext {

	private DefaultBeanFactory beanFactory=null;
	
	public ClassPathXmlApplicationContext(String configfile) {
		beanFactory=new DefaultBeanFactory();
		XmlBeanDefinitionReader read=new XmlBeanDefinitionReader(beanFactory);
		read.loadBeanDefinition(configfile);
	}
	@Override
	public Object getBean(String beanId) {
		
		return beanFactory.getBean(beanId);
	}

}
