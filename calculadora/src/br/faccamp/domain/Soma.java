package br.faccamp.domain;

public class Soma extends Operacao {

	public Soma(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String conteudo) {
		double segundo = new Double(conteudo);
		guardarValorFixo(segundo);
		return ((primeiro+getFixo())+"");

	}



}
