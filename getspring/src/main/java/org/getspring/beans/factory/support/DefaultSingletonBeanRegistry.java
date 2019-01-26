package org.getspring.beans.factory.support;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.getspring.beans.factory.config.SingletonBeanRegistry;
import org.junit.Assert;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	private final Map<String, Object> singletonObjects = new ConcurrentHashMap<String, Object>(46);

	@Override
	public void registerSingleton(String beanName, Object singletonBean) {
		Assert.assertNotNull(beanName, "beanName must not be null");
		Object oldObject = singletonObjects.get(beanName);
		if (oldObject != null) {
			throw new IllegalStateException("Could not register object [" + singletonBean + "] under bean name"
					+ beanName + ":there is already object [" + oldObject + "]");
		}
		this.singletonObjects.put(beanName, singletonBean);
	}

	@Override
	public Object getSingleton(String beanName) {
		return this.singletonObjects.get(beanName);
	}

}
