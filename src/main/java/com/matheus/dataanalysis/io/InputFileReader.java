package com.matheus.dataanalysis.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.matheus.dataanalysis.model.InputFile;
import com.matheus.dataanalysis.parser.IFileParser;

public class InputFileReader {

	private static Logger logger = Logger.getLogger(InputFileReader.class.getName());
	private IFileParser fileParser;

	public InputFileReader(IFileParser parser) {
		this.fileParser = parser;
		
	}

	public InputFile read(Path filePath, String fileName) {
		InputFile inputFile = null;

		List<String> lines = new ArrayList<>();
		try (FileReader reader = new FileReader(filePath.resolve(fileName).toString(), StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(reader)) {

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

			if (!lines.isEmpty()) {
				inputFile = fileParser.parseFile(fileName, lines);
			}
		} catch (Exception ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}

		return inputFile;
	}

}
