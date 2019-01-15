package org.getspring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;

public class FileSystemPathResource implements Resource {

	private  String path;
	private File file;
	
	public FileSystemPathResource(String path) {
		Assert.assertNotNull("path must not be null", path);
		this.file=new File(path);
	}
	
	@Override
	public String getDescription() {
		
		return "file ["+this.file.getAbsolutePath()+"]";
	}

	@Override
	public InputStream getInputStream() throws IOException {
		
		return new FileInputStream(this.file);
	}

}
