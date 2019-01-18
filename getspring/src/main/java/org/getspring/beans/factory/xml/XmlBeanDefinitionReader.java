package org.getspring.beans.factory.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.support.BeanDefinitionRegistry;
import org.getspring.beans.factory.support.GenericBeanDefinition;
import org.getspring.core.io.Resource;
import org.getspring.util.ClassUtils;

public class XmlBeanDefinitionReader {
	private static final String ID = "id";

	private static final String NAME = "class";

	BeanDefinitionRegistry beanDefinitionRegistry;

	public XmlBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
		this.beanDefinitionRegistry = beanDefinitionRegistry;
	}

	public void loadBeanDefinition(Resource resource) {
		InputStream is = null;
		try {
			is=resource.getInputStream();
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
				beanDefinitionRegistry.registerBeanDefinition(id, bd);
			}
		} catch (Exception e) {
			throw new BeanDefinitionStoreException("IOException parsing XML" + resource.getDescription() + "error", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
