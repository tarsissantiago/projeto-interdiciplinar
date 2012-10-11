package br.faccamp.domain;

public class XElevadoY extends Operacao{

	public XElevadoY(String primeiro) {
		super(primeiro);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String calcula(String conteudo) {
		double segundo = new Double(conteudo);
		guardarValorFixo(segundo);
		return ((Math.pow(primeiro,getFixo())+""));
	}

}
