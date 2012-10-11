package br.faccamp.domain;

import javax.swing.JOptionPane;

public class Fatorial extends Operacao {

	public Fatorial(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String conteudo) {
		double valor = new Double(conteudo);
		if (valor > 170) {
			JOptionPane.showMessageDialog(null,
					"Desculpe, número muito grande\nnúmero maximo 170",
					"Calculadora", 1);
			return "0";
		} else {
			if (valor > 0) {
				return "" + valor * Double.parseDouble(calcula(valor - 1 + ""));
			} else
				return "1";
		}
	}
}