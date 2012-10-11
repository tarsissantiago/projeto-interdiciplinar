package br.faccamp.domain;

import javax.swing.JOptionPane;

public class Divisao extends Operacao {

	public Divisao(String primeiro) {
		super(primeiro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String calcula(String conteudo) {

		double segundo = new Double(conteudo);
		if (segundo == 0) {
			JOptionPane.showMessageDialog(null, " N�o existe Dives�o por zero","Calculadora",1);
			return ("0");
		} else {
			guardarValorFixo(segundo);
			return ((primeiro / getFixo()) + "");
		}
	}
}
