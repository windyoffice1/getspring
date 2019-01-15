package org.getspring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.getspring.util.ClassUtils;

public class ClassPathResource implements Resource {

	private String path;
	
	private ClassLoader classLoader;
	
	public ClassPathResource(String path) {
		this(path,null);
	}
	
	public ClassPathResource(String path,ClassLoader classLoader) {
		this.path=path;
		this.classLoader=(classLoader!=null)?classLoader:ClassUtils.getDefaultClassLoader();
	}
	@Override
	public InputStream getInputStream() throws IOException{
		InputStream is=this.classLoader.getResourceAsStream(this.path);
		if(is==null) {
			throw new FileNotFoundException(path+"cant not be open");
		}
		return is;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.path;
	}

}
