package com.matheus.dataanalysis.parser;

import java.util.List;

import com.matheus.dataanalysis.exception.InvalidFormatFileException;
import com.matheus.dataanalysis.exception.InvalidLineDataSizeException;
import com.matheus.dataanalysis.model.InputFile;

public interface IFileParser {
	InputFile parseFile(String fileName, List<String> lines)
			throws InvalidLineDataSizeException, InvalidFormatFileException;
}
