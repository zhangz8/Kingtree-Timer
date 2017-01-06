package com.kingtree.timer.util;

import java.io.File;

public class ContextFileUtil {

	public static File getSysDirectory(String fileName) {
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "document";
		File file = new File(path + File.separator + fileName);
		return file;
	}
}
