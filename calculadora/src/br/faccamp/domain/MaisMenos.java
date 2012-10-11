package br.faccamp.domain;

public class MaisMenos extends Operacao{

	public MaisMenos(String primeiro) {
		super(primeiro);
	}

	@Override
	public String calcula(String conteudo) {
		double valor=new Double(conteudo);
	if(valor!=0)
		return ((valor*(-1))+"");
	else
		return(valor+"");
	}

}
