package com.matheus.dataanalysis.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {

	private PathUtil() {
		throw new IllegalStateException();
	}

	public static void createIfNotExists(String InOutPath) throws IOException {

		Path path = Paths.get(InOutPath);

		if (!Files.exists(path))
			Files.createDirectories(path);
	}

}
