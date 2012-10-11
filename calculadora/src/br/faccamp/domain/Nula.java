package br.faccamp.domain;

public class Nula extends Operacao {

	public Nula(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String segundo) {
		return segundo;
	}
}
