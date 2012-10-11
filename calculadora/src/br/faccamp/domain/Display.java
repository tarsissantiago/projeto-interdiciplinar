package br.faccamp.domain;

import br.faccamp.view.CalculadoraGUI;

public class Display {

	private CalculadoraGUI gui;
	boolean finalDoNumero;
	boolean digitou;
	String copia;

	// Construtor da classe
	public Display(CalculadoraGUI gui) {
		this.gui = gui;

	}

	// Metodo atualiza
	//
	// Metodo que atualiza o display
	// e tem um algoritimo que testa o estado
	// do display para a atualização correta
	public void atualiza(String texto) {

		if ((getConteudo().equalsIgnoreCase("0") && !(texto
				.equalsIgnoreCase("."))) || finalDoNumero) {

			zeraDisplay();
			gui.atualizaDisplay(texto);
			finalDoNumero = (false);
		} else {
			gui.atualizaDisplay((getConteudo() + texto));
		}
		digitou = (true);
	}

	public void podeDigitar(String texto) {
		if (finalDoNumero)
			atualiza("0" + texto);
		else if (getConteudo().indexOf(texto) == -1) {
			atualiza(texto);
		}

	}

	public String analizaResultado(String resultado) {
		if (resultado.charAt(resultado.length() - 1) == '0') {
			resultado = resultado.replace('.', ' ');
			String results[] = resultado.split(" ");
			return results[0];
		} else
			return resultado;
	}

	public String getConteudo() {
		return gui.getDisplay();
	}

	public void zeraDisplay() {
		gui.atualizaDisplay("0");
	}
}