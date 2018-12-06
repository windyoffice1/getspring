package org.getspring.beans.factory.support;

import org.getspring.beans.BeanDefinition;

public interface BeanDefinitionRegistry {

	BeanDefinition getBeanDefinition(String beanID);
	void registerBeanDefinition(String id, BeanDefinition bd);

}
