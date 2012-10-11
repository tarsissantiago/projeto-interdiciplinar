package br.faccamp.domain;

public abstract class Operacao {
	protected double primeiro;
	private Double fixo=null;

	public Operacao(String primeiro) {
		this.primeiro = new Double(primeiro);
	}
	protected void guardarValorFixo(double valor){
		if (fixo==null){
			fixo=valor;
		}else{
			primeiro=valor;
		}
	}
	protected  Double getFixo() {
		return fixo;
	}
	public abstract String calcula(String conteudo);
}
