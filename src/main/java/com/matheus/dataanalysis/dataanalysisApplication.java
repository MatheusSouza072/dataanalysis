package com.matheus.dataanalysis;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.dataanalysis.io.InputFileReader;
import com.matheus.dataanalysis.io.OutputFileWriter;
import com.matheus.dataanalysis.model.InputFile;
import com.matheus.dataanalysis.model.OutputFile;
import com.matheus.dataanalysis.parser.SalesFileParser;
import com.matheus.dataanalysis.service.DirectoryWatcher;
import com.matheus.dataanalysis.util.PathUtil;

import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class dataanalysisApplication {

	private static Logger logger = Logger.getLogger(dataanalysisApplication.class.getName());
	private static String inputPath;
	private static String outputPath;
	public static final String INPUT_PATH = "%s/data/in";
	public static final String OUTPUT_PATH = "%s/data/out"; 

	public static void main(String[] args) {
		SpringApplication.run(dataanalysisApplication.class, args);

		configurePaths();
		createDirectoriesIfNotExists();

		DirectoryWatcher directoryWatcher = new DirectoryWatcher(inputPath, outputPath);
		directoryWatcher.start();
	} 

	private static void configurePaths() {
		String homePath = System.getProperty("user.home");

		inputPath = String.format(INPUT_PATH, homePath);
		outputPath = String.format(OUTPUT_PATH, homePath);
	}

	private static void createDirectoriesIfNotExists() {
		try {
			PathUtil.createIfNotExists(inputPath);
			PathUtil.createIfNotExists(outputPath);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Não foi possível criar os diretórios de entrada/saida.", e);
		}
	}

	public void processFile(Path inputPath, Path outputPath, String fileName) {
		logger.log(Level.INFO, () -> "Processando o arquivo " + fileName + " ...");

		SalesFileParser salesFileParser = new SalesFileParser();
		InputFileReader inputFileReader = new InputFileReader(salesFileParser);

		InputFile inputFile = inputFileReader.read(inputPath, fileName);
		String outputReport = inputFile.generateReport();

		OutputFileWriter outputFileWriter = new OutputFileWriter(outputPath);
		OutputFile outputFile = new OutputFile(fileName, outputReport);
		outputFileWriter.write(outputFile);

		logger.log(Level.INFO, () -> "O arquivo '" + fileName + "' foi processado com sucesso!");
	}
}
