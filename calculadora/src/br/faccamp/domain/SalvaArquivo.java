package br.faccamp.domain;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;



public class SalvaArquivo {
	
	 public void salvar(String conteudo, String data) throws IOException{
	File outFile = new File(data+"_calc.csv");
	FileWriter fw = new FileWriter(outFile);
	  
	fw.write(conteudo);
	fw.close();

	 }
}
