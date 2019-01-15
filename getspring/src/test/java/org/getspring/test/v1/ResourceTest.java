package org.getspring.test.v1;

import java.io.InputStream;

import org.getspring.core.io.ClassPathResource;
import org.getspring.core.io.FileSystemPathResource;
import org.getspring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {

	@Test
	public void testClassPathResource() {
		Resource resource = new ClassPathResource("petstore-v1.xml");
		InputStream is = null;
		try {
			is = resource.getInputStream();
			Assert.assertNotNull(is);
		} catch (Exception e) {

		}
	}
	
	@Test
	public void testFilePathResource() {
		Resource resource = new FileSystemPathResource("C:\\git-workspace\\getspring\\getspring\\src\\test\\resources\\petstore-v1.xml");
		InputStream is = null;
		try {
			is = resource.getInputStream();
			Assert.assertNotNull(is);
		} catch (Exception e) {

		}
	}
}
