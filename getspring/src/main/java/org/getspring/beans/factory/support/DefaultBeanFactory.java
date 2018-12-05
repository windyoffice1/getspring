package org.getspring.beans.factory.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanFactory;
import org.getspring.util.ClassUtils;

public class DefaultBeanFactory implements BeanFactory {

	private static final String ID = "id";

	private static final String NAME = "class";

	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

	public DefaultBeanFactory(String configfile) {
		loadBeanDefinition(configfile);
	}

	private void loadBeanDefinition(String configfile) {
		InputStream is = null;
		try {
			ClassLoader cl = ClassUtils.getDefaultClassLoader();
			is = cl.getResourceAsStream(configfile);
			SAXReader read = new SAXReader();
			Document document = read.read(is);
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			Iterator<Element> iter = root.elementIterator();
			while (iter.hasNext()) {
				Element ele = iter.next();
				String id = ele.attributeValue(ID);
				String beanName = ele.attributeValue(NAME);
				BeanDefinition bd = new GenericBeanDefinition(id, beanName);
				beanDefinitionMap.put(id, bd);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public BeanDefinition getBeanDefinition(String beanId) {
		return beanDefinitionMap.get(beanId);
	}

	@Override
	public Object getBean(String beanId) {
		BeanDefinition bd = this.getBeanDefinition(beanId);
		if (bd == null) {
			return null;
		}
		String beanClassName = bd.getBeanClassName();
		ClassLoader cl = ClassUtils.getDefaultClassLoader();
		try {
			Class<?> clazz = cl.loadClass(beanClassName);
			try {
				return clazz.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
