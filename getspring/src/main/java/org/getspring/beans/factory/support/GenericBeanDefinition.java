package org.getspring.beans.factory.support;

import org.getspring.beans.BeanDefinition;

public class GenericBeanDefinition implements BeanDefinition {

	private String id;
	private String beanName;

	public GenericBeanDefinition(String id, String beanName) {
		this.id = id;
		this.beanName = beanName;
	}

	@Override
	public String getBeanClassName() {

		return this.beanName;
	}

}
