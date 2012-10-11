package br.faccamp.domain;

public class Log extends Operacao {

	public Log(String primeiro) {
		super(primeiro);

	}

	@Override
	public String calcula(String conteudo) {

		double segundo = new Double(conteudo);
		guardarValorFixo(segundo);
		return ((Math.log(primeiro) + ""));
	}

}