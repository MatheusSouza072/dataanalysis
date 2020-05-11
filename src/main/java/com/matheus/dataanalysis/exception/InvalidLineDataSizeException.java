package com.matheus.dataanalysis.exception;

public class InvalidLineDataSizeException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLineDataSizeException(){
        super("Quantidade de registros da linha inválido!");
    }
}
 