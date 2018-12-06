package org.getspring.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanCreationException;
import org.getspring.beans.factory.BeanFactory;
import org.getspring.util.ClassUtils;

public class DefaultBeanFactory implements BeanFactory, BeanDefinitionRegistry {

	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

	@Override
	public Object getBean(String beanId) {
		BeanDefinition bd = this.getBeanDefinition(beanId);
		if (bd == null) {
			throw new BeanCreationException("Bean Definition does not exits");
		}
		String beanClassName = bd.getBeanClassName();
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
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

}
