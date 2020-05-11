package com.matheus.dataanalysis.parser;

import java.util.List;

import com.matheus.dataanalysis.exception.InvalidFormatFileException;
import com.matheus.dataanalysis.exception.InvalidLineDataSizeException;
import com.matheus.dataanalysis.model.SalesInputFile;

public class SalesFileParser implements IFileParser {
    private static final String SPLIT_CHAR_LINES = "ç";
    private static final String ID_SELLER = "001";
    private static final String ID_CUSTOMER = "002";
    private static final String ID_SALE = "003";

    @Override
    public SalesInputFile parseFile(String fileName, List<String> lines) throws InvalidLineDataSizeException, InvalidFormatFileException {
        SalesInputFile salesInputFile = new SalesInputFile(fileName);

        String[] splittedLine;
        for (String line: lines) {
            splittedLine = line.split(SPLIT_CHAR_LINES);

            switch (splittedLine[0]){
                case ID_SELLER:
                    salesInputFile.addSeller(SellerParser.parse(splittedLine));
                    break;
                case ID_CUSTOMER:
                    salesInputFile.addCustomer(CustomerParser.parse(splittedLine));
                    break;
                case ID_SALE:
                    salesInputFile.addSale(SaleParser.parse(splittedLine));
                    break;
                default:
                    throw new InvalidFormatFileException();
            }
        }


        return salesInputFile;
    }
}
