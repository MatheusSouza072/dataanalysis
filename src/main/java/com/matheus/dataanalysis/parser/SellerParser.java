package com.matheus.dataanalysis.parser;

import com.matheus.dataanalysis.exception.InvalidLineDataSizeException;
import com.matheus.dataanalysis.model.Seller;

public class SellerParser {

    private SellerParser(){
        throw new IllegalStateException();
    }

    private static final int CPF = 1;
    private static final int NAME = 2;
    private static final int SALARY = 3;

    private static final int LINE_LENGTH = 4;

    public static Seller parse(String[] lineData) throws InvalidLineDataSizeException {

        if (lineData.length != LINE_LENGTH)
            throw new InvalidLineDataSizeException();

        return new Seller(lineData[CPF], lineData[NAME], Double.parseDouble(lineData[SALARY]));
    }


}
