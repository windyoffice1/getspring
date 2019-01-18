package org.getspring.beans.factory.context.support;

import org.getspring.core.io.FileSystemPathResource;
import org.getspring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {

	
	public FileSystemXmlApplicationContext(String configfile) {
		super(configfile);
	}
	
	@Override
	protected Resource getResourceByPath(String path) {
		// TODO Auto-generated method stub
		return new FileSystemPathResource(path);
	}

}
