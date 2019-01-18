package org.getspring.beans.factory.context.support;

import org.getspring.core.io.ClassPathResource;
import org.getspring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	public ClassPathXmlApplicationContext(String configFile) {
		super(configFile);
	}

	@Override
	protected Resource getResourceByPath(String path) {
		
		return new ClassPathResource(path,this.getBeanClassLoader());
	}

	

}
