package br.faccamp.domain;

public class Porcentual extends Operacao {

	public Porcentual(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String conteudo) {
		String results[] = conteudo.split(" ");
		double primeiro = new Double(results[0]);
		double segundo = new Double(results[1]);
		String resultado;
		resultado = (primeiro * segundo) / 100 + "";
		return resultado;
	}

}
