package org.getspring.beans.factory.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.getspring.beans.BeanDefinition;
import org.getspring.beans.factory.BeanDefinitionStoreException;
import org.getspring.beans.factory.support.BeanDefinitionRegistry;
import org.getspring.beans.factory.support.GenericBeanDefinition;
import org.getspring.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XmlBeanDefinitionReader {
	private static final String ID_ATTRIBUTE = "id";

	private static final String CLASS_ATTRIBUTE = "class";
	
	private static final String SCOPE_ATTRIBUTE="scope";

	private static final String PROPERTY_ELEMENT="property";

	private static final String REF_ATTRIBUTE="ref";

	private static final String NAME_ATTRIBUTE="name";

	private static final String VALUE_ATTRIBUTE="value";

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
				String id = ele.attributeValue(ID_ATTRIBUTE);
				String beanName = ele.attributeValue(CLASS_ATTRIBUTE);
				BeanDefinition bd = new GenericBeanDefinition(id, beanName);
				if(ele.attributeValue(SCOPE_ATTRIBUTE)!=null) {
					bd.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
				}
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
