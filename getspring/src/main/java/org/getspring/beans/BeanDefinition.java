package org.getspring.beans;

import java.util.List;

public interface BeanDefinition {

	public static final String SCOPE_SINGLETON="singleton";
	public static final String SCOPE_PROTOTYE="prototype";
	public static final String  SCOPE_DEFAULT = "";
	public boolean isSingleton();
	public boolean isPrototype();
	String getScope();
	public void setScope(String scope);
	
	String getBeanClassName();


	List<PropertyValue> getPropertyValues();
}
