package br.faccamp.domain;

import java.util.ArrayList;


public class PilhaValores {
	ArrayList<String> valores = new ArrayList<String>();
	ArrayList<String> valoresPassados = new ArrayList<String>();
	
	public void addValor(String valor) {
		valores.add(valor);

	}

	public String getValor() {
		if(valores.size()==0){
			return "0";
		}
		String texto = valores.get(valores.size() - 1);
		valores.remove(valores.size() - 1);
		return texto;

}
}