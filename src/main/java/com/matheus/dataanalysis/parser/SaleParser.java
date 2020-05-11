package com.matheus.dataanalysis.parser;

import java.util.ArrayList;
import java.util.List;

import com.matheus.dataanalysis.exception.InvalidLineDataSizeException;
import com.matheus.dataanalysis.model.Item;
import com.matheus.dataanalysis.model.Sale;


public class SaleParser {

    private SaleParser() {
        throw new IllegalStateException();
    }

    private static final int ID = 1;
    private static final int ITENS = 2;
    private static final int SELLER_NAME = 3;
    public static final String SPLIT_CHAR_ITENS_LINE = "-";
    public static final String SPLIT_CHAR_ITENS = ",";


    private static final int LINE_LENGTH = 4;

    public static Sale parse(String[] lineData) throws InvalidLineDataSizeException {

        if (lineData.length != LINE_LENGTH)
            throw new InvalidLineDataSizeException();

        return new Sale(Integer.parseInt(lineData[ID]), getItemsFromLine(lineData[ITENS]), lineData[SELLER_NAME]);
    }

    public static List<Item> getItemsFromLine(String itemLine) throws InvalidLineDataSizeException {
        List<Item> itens = new ArrayList<>();

        String[] splittedItens = itemLine.replace("[", "").replace("]", "").split(SPLIT_CHAR_ITENS);
        String[] currItem;

        for (String splitItem: splittedItens) {
            currItem = splitItem.split(SPLIT_CHAR_ITENS_LINE);
            itens.add(ItemParser.parse(currItem));
        }

        return itens;
    }

}
