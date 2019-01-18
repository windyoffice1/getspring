package org.getspring.beans.factory.config;

import org.getspring.beans.factory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory{

	void setBeanClassLoader(ClassLoader classLoader);
	
	ClassLoader getBeanClassLoader();
}
