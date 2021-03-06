package org.getspring.beans.factory.support;

import org.getspring.beans.BeanDefinition;
import org.getspring.beans.PropertyValue;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {

	private String id;
	private String beanName;
	private boolean singleton=true;
	private boolean prototye=false;
	private String scope=SCOPE_DEFAULT;
	private List<PropertyValue> pvs=new ArrayList<>();
	public GenericBeanDefinition(String id, String beanName) {
		this.id = id;
		this.beanName = beanName;
	}

	@Override
	public String getBeanClassName() {
		return this.beanName;
	}

	@Override
	public List<PropertyValue> getPropertyValues() {
		return this.pvs;
	}

	@Override
	public boolean isSingleton() {
		return this.singleton;
	}

	@Override
	public boolean isPrototype() {
		return this.prototye;
	}

	@Override
	public String getScope() {
		return this.scope;
	}

	@Override
	public void setScope(String scope) {
		this.scope=scope;
		this.singleton=SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
		this.prototye=SCOPE_PROTOTYE.equals(scope);
	}

}
