package org.getspring.beans;

public interface BeanDefinition {

	public static final String SCOPE_SINGLETON="singleton";
	public static final String SCOPE_PROTOTYE="prototype";
	public static final String  SCOPE_DEFAULT = "";
	public boolean isSingleton();
	public boolean isPrototype();
	String getScope();
	public void setScope(String scope);
	
	String getBeanClassName();
	
	

}
