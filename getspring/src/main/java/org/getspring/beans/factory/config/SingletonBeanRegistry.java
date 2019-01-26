package org.getspring.beans.factory.config;

public interface SingletonBeanRegistry {
	
	void registerSingleton(String beanName,Object singletonBean);
	
	Object getSingleton(String beanName);

}
