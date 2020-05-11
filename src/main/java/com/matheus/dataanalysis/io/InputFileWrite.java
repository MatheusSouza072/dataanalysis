package com.matheus.dataanalysis.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.UUID;

public class InputFileWrite {

	public static void main(String[] args) throws IOException {

		String teste1 = "001ç1234567891234çAlineç50000\n";
		String teste2 = "001ç3245678865434çMatheusç40000.99\n";
		String teste3 = "002ç2345675434544345çCarlos da SilvaçRural\n";
		String teste4 = "002ç2345675433444345çEdnaldo PereiraçRural\n";
		String teste5 = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çAline\n";
		String teste6 = "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çMatheus\n";

		String path = "\\data\\in\\";
		String home = System.getProperty("user.home");
		new File(home + "\\data\\in").mkdirs();

		// ObjectOutputStream oos = new ObjectOutputStream(new
		// FileOutputStream(home+"\\data\\in"+"\\arquivo.dat"));

		String randomNameFile = UUID.randomUUID().toString();

		System.out.println(randomNameFile.toString());

		BufferedWriter fw = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(home + path + randomNameFile + ".dat"), "UTF-8"));

		fw.write(teste1);
		fw.write(teste2);
		fw.write(teste3);
		fw.write(teste4);
		fw.write(teste5);
		fw.write(teste6);
 
		fw.close();
	}
}