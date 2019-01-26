package org.getspring.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.config.ConfigurableBeanFactory;
import org.getspring.util.ClassUtils;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory, BeanDefinitionRegistry {

	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
	
	private ClassLoader classLoader;

	@Override
	public Object getBean(String beanId) {
		BeanDefinition bd = this.getBeanDefinition(beanId);
		if (bd == null) {
			throw new BeanCreationException("Bean Definition does not exits");
		}
		if(bd.isSingleton()) {
			Object bean=this.getSingleton(beanId);
			if(bean==null) {
				bean=createBean(bd);
				this.registerSingleton(beanId, bean);
			}
			return bean;
		}
		return createBean(bd);
		
	}

	private Object createBean(BeanDefinition bd) {
		String beanClassName = bd.getBeanClassName();
		ClassLoader cl =this.getBeanClassLoader();
		try {
			Class<?> clazz = cl.loadClass(beanClassName);
			return clazz.newInstance();

		} catch (Exception e) {
			throw new BeanCreationException("create bean for" + beanClassName + "error");
		}
	}

	@Override
	public void registerBeanDefinition(String id, BeanDefinition bd) {
		beanDefinitionMap.put(id, bd);
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanId) {
		return beanDefinitionMap.get(beanId);
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

}
