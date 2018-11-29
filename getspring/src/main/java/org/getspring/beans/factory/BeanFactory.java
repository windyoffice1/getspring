package org.getspring.beans.factory;

import org.getspring.beans.BeanDefinition;

public interface BeanFactory {

	BeanDefinition getBeanDefinition(String beanId);

	Object getBean(String beanId);

}
