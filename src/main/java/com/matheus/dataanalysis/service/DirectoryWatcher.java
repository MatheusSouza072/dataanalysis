package com.matheus.dataanalysis.service;

import java.nio.file.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.matheus.dataanalysis.dataanalysisApplication;

public class DirectoryWatcher {

	private static Logger logger = Logger.getLogger(DirectoryWatcher.class.getName());

	private Path pathToWatch;
	private Path outputPath;
	public static final String FILE_EXTENSION_INPUT = ".dat";

	public DirectoryWatcher(String inputPath, String outputPath) {
		this.pathToWatch = Paths.get(inputPath);
		this.outputPath = Paths.get(outputPath);
	}

	public void start() {
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();

			pathToWatch.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

			logger.log(Level.INFO, () -> "Watching directory: " + pathToWatch);

			boolean valid;
			do {
				WatchKey watchKey = watchService.take();
				dataanalysisApplication salesfileanalyzerApplication = new dataanalysisApplication();

				for (WatchEvent<?> event : watchKey.pollEvents()) {
					if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
						String fileName = event.context().toString();

						if (validExtension(fileName)) {
							new Thread(() -> {
								try {
									preventSameFileUsage();
									salesfileanalyzerApplication.processFile(pathToWatch, outputPath, fileName);
								} catch (Exception e) {
									logger.log(Level.SEVERE, e.getMessage());
								}
							}).start();
						}
					}
				}
				valid = watchKey.reset();

			} while (valid);

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	private void preventSameFileUsage() throws InterruptedException {
		Thread.sleep(100);
	}

	private static boolean validExtension(String fileName) {
		return fileName.endsWith(FILE_EXTENSION_INPUT);
	}

}
