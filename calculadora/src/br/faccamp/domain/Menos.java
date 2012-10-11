package br.faccamp.domain;

public class Menos  extends  Operacao{

		public Menos(String primeiro) {
		super(primeiro);
		// TODO Auto-generated constructor stub
	}
	


	@Override
	public String calcula(String conteudo) {
		double segundo = new Double(conteudo);
		guardarValorFixo(segundo);
		return ((primeiro-getFixo())+"");

	}	
}
