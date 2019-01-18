package org.getspring.beans.factory.context.support;

import org.getspring.beans.factory.context.ApplicationContext;
import org.getspring.beans.factory.support.DefaultBeanFactory;
import org.getspring.beans.factory.xml.XmlBeanDefinitionReader;
import org.getspring.core.io.Resource;
import org.getspring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {

	private DefaultBeanFactory beanFactory=null;
	private ClassLoader classLoader;
	
	public AbstractApplicationContext(String configfile) {
		beanFactory=new DefaultBeanFactory();
		XmlBeanDefinitionReader read=new XmlBeanDefinitionReader(beanFactory);
		Resource resource=this.getResourceByPath(configfile);
		read.loadBeanDefinition(resource);
		beanFactory.setBeanClassLoader(this.getBeanClassLoader());
	}
	@Override
	public Object getBean(String beanId) {
		
		return beanFactory.getBean(beanId);
	}
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		this.classLoader=classLoader;
	}

	@Override
	public ClassLoader getBeanClassLoader() {
		// TODO Auto-generated method stub
		return this.classLoader!=null?this.classLoader:ClassUtils.getDefaultClassLoader();
	}
	protected abstract Resource getResourceByPath(String configfile);


}
