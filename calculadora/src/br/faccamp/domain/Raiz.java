package br.faccamp.domain;

import javax.swing.JOptionPane;

public class Raiz extends Operacao {

	public Raiz(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String conteudo) {
		double valor = new Double(conteudo);
		if (valor >= 0)
			return (Math.sqrt(valor)) + "";
		else {
			JOptionPane.showMessageDialog(null, " Valor Inválido","Calculadora",1);
			return ("0");
		}
	}
}
