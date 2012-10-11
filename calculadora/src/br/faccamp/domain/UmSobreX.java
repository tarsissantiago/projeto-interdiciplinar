package br.faccamp.domain;

import javax.swing.JOptionPane;

public class UmSobreX extends Operacao {

	public UmSobreX(String primeiro) {
		super(primeiro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String calcula(String conteudo) {
		double segundo= new Double(conteudo);
		if (segundo == 0) {
			JOptionPane.showMessageDialog(null, " Não existe Divesão por zero","Calculadora",1);
			return ("0");
		}else
		return (1/segundo)+"";
	}

}
