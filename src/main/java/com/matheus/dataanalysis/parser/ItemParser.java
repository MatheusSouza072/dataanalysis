package com.matheus.dataanalysis.parser;

import com.matheus.dataanalysis.exception.InvalidLineDataSizeException;
import com.matheus.dataanalysis.model.Item;

public class ItemParser {

    private ItemParser (){
        throw new IllegalStateException();
    }

    private static final int ID = 0;
    private static final int QUANTITY = 1;
    private static final int PRICE = 2;

    private static final int LINE_LENGTH = 3;

    public static Item parse(String[] line) throws InvalidLineDataSizeException {

        if (line.length != LINE_LENGTH)
            throw new InvalidLineDataSizeException();

        return new Item(Integer.parseInt(line[ID]), Integer.parseInt(line[QUANTITY]), Double.parseDouble(line[PRICE]));
    }


}
