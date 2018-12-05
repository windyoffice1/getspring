package org.getspring.util;

public class ClassUtils {

	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Exception e) {
		}
		if (cl == null) {
			cl = ClassUtils.class.getClassLoader();
			if (cl == null) {
				cl = ClassLoader.getSystemClassLoader();
			}
		}
		return cl;
	}

}
