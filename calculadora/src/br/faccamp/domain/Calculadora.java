package br.faccamp.domain;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.sun.org.apache.bcel.internal.generic.SALOAD;

import br.faccamp.view.CalculadoraGUI;

public class Calculadora {

	private CalculadoraGUI gui;
	private Display display;
	private double Memoria = 0;
	private boolean expressao = false;
	private PilhaValores pilha = new PilhaValores();
	private String valorPilha="";
	private Operacao aux, operacao = new Nula("0");

	public Calculadora() {
		gui = new CalculadoraGUI(this);
		display = new Display(gui);
	}

	// ***************************Memoria**************************

	public double getMemoria() {
		return Memoria;
	}

	public void setMemoria(double string) {
		Memoria = string;
	}

	public void processaMC() {
		setMemoria(0);

	}

	public void processaMR() {
		gui.atualizaDisplay(display.analizaResultado(getMemoria() + ""));
		display.finalDoNumero = (true);
	}

	public void processaMS() {
		setMemoria(new Double(gui.getDisplay()));
		display.finalDoNumero = (true);
	}

	public void processaMMais() {
		setMemoria(getMemoria() + Double.parseDouble(gui.getDisplay()));
		display.finalDoNumero = (true);
	}

	public void processaMMenos() {
		setMemoria((getMemoria()) - Double.parseDouble(gui.getDisplay()));
		display.finalDoNumero = (true);

	}

	// *************teclado Numerico*********************

	public void processaZero() {
		display.atualiza("0");
	}

	public void processaUm() {
		display.atualiza("1");
	}

	public void processaDois() {
		display.atualiza("2");
	}

	public void processaTres() {
		display.atualiza("3");
	}

	public void processaQuatro() {
		display.atualiza("4");
	}

	public void processaCinco() {
		display.atualiza("5");
	}

	public void processaSeis() {
		display.atualiza("6");
	}

	public void processaSete() {
		display.atualiza("7");
	}

	public void processaOito() {
		display.atualiza("8");
	}

	public void processaNove() {
		display.atualiza("9");
	}

	public void processaVirgula() {
		display.podeDigitar(".");
	}

	// Operaçoes

	public void processaIgual() {
		display.finalDoNumero = true;
		String valor = display.getConteudo();
		valorPilha+=valor;
		String texto = operacao.calcula(valor);
		String resultado = display.analizaResultado(texto);
		valorPilha+=("="+resultado+"; ");
		display.atualiza(resultado);
		display.finalDoNumero = true;
		expressao = false;
		pilha.addValor(valorPilha);
		valorPilha=""; 

	}

	// ****************Operações com dois valores************************

	public void processaVezes() {
		if (expressao) {
			processaIgual2();
			operacao = new Multiplicacao(display.getConteudo());
		} else {
			operacao = new Multiplicacao(display.getConteudo());
		}
		botaoPressioado("*");

	}

	public void processaDivisao() {
		if (expressao) {
			processaIgual2();
			operacao = new Divisao(display.getConteudo());
		} else {
			operacao = new Divisao(display.getConteudo());
		}
		botaoPressioado("/");

	}

	public void processaMenos() {
		if (expressao) {
			processaIgual2();
			operacao = new Menos(display.getConteudo());
		} else {
			operacao = new Menos(display.getConteudo());
		}
		botaoPressioado("-");
	}

	public void processaMais() {
		if (expressao) {
			processaIgual2();
			operacao = new Soma(display.getConteudo());
		} else {
			operacao = new Soma(display.getConteudo());
		}
		botaoPressioado("+");
	}

	private void botaoPressioado(String op) {
		String valor = display.getConteudo();
			valorPilha+=valor+op;
		display.finalDoNumero = true;
		expressao = true;
		display.digitou = false;
	}

	private void processaIgual2() {
		if (display.digitou) {
			display.finalDoNumero = true;
			String valor = display.getConteudo();
			valorPilha+=valor;
			String texto = operacao.calcula(valor);
			String resultado = display.analizaResultado(texto);
			valorPilha+=("="+resultado+"; ");
			display.atualiza(resultado);
			display.finalDoNumero = true;
			pilha.addValor(valorPilha);
			valorPilha="";
		}
	}

	public void processaXElevadoY() {
		if (expressao) {
			processaIgual2();
			operacao = new XElevadoY(display.getConteudo());
		} else {
			operacao = new XElevadoY(display.getConteudo());
		}
		botaoPressioado("elevado");

	}

	// ****************Operaçoes comumvalor************************************

	public void processaRaiz() {
		operacao = new Raiz(display.getConteudo());
		botaoPressioado("Raiz");
		processaIgual();
		operacao = new Nula("0");
	}

	public void processaMaisOuMenos() {
		aux = operacao;
		operacao = new MaisMenos(display.getConteudo());
		String texto = operacao.calcula(display.getConteudo());
		String resultado = display.analizaResultado(texto);
		display.finalDoNumero = true;
		display.atualiza(resultado);
		display.finalDoNumero = false;
		operacao = aux;

	}

	public void processaFatorial() {
		operacao = new Fatorial(display.getConteudo());
		botaoPressioado("!");
		processaIgual();
		operacao = new Nula("0");

	}

	public void processaPorcentual() {
		aux = operacao;
		operacao = new Porcentual(display.getConteudo());
		String texto = aux.primeiro + " ";
		texto += display.getConteudo();
		String valor = operacao.calcula(texto);
		String resultado = display.analizaResultado(valor);
		display.finalDoNumero = true;
		display.atualiza(resultado);
		operacao = aux;
	}

	public void processaUmSobreX() {
		operacao = new UmSobreX(display.getConteudo());

		botaoPressioado("1/");
		processaIgual();
		operacao = new Nula("0");
	}

	public void processaLog() {
		operacao = new Log(display.getConteudo());

		botaoPressioado("log");
		processaIgual();
		operacao = new Nula("0");
	}

	// memoria & funçoes calculadora

	public void processaCE() {
		display.zeraDisplay();
	}

	public void processaC() {
		gui.atualizaDisplay("0");
		expressao = (false);
		operacao = new Nula("0");

	}

	public void ProcessaColar() {
		if (display.copia != null) {
			String resultado = display.copia;
			display.finalDoNumero = true;
			display.atualiza(resultado);
			display.finalDoNumero = false;
		}
	}

	public void ProcessaCopiar() {
		// TODO Auto-generated method stub
		display.copia = display.getConteudo();
	}

	public void processaUndo() {
		display.finalDoNumero = true;
		//display.atualiza(display.getValor());
		display.finalDoNumero = false;
	}

	public void processaBackSpace() {
		String texto = display.getConteudo();
		String resultado;
		if (texto.length() > 1)
			resultado = texto.substring(0, texto.length() - 1);
		else
			resultado = texto;
		display.finalDoNumero = true;
		display.atualiza(resultado);
		display.finalDoNumero = false;

	}

	public void processaSobre() {
		String conteudo = "Calculadora implementada por Tarsis Santiago de Oliveira\n"
				+ "Aluno da turma do 4° Semestre de Ciências da Computação\n"
				+ "FACCAMP.\nRa:13,930."
				+ "\n\n*Foi feita a implementação de todos os botões e operações."
				+ "\n*Mapeamento do teclado (KeyListener)."
				+ "\n*Salva um arquivo Csv ao fechar a aplicação"
				+ "\n*Postado no GitHub em http://github/tarsissantiago/projeto-interdiciplinar"
				+ "\n\n    Foi implementado tambem..."
				+ "\n*Display personalizado\n*Multiplas Operações sem usar o igual"
				+ "\n*MenuBar\n*BackSpace\n*Janela de Hitórico." +
				"\n* E icone personalizado na janela.";
		JOptionPane.showMessageDialog(null, conteudo, "Sobre.", JOptionPane.PLAIN_MESSAGE);
	}

	public void processaHistorico() {
		String conteudo="";
		for(int i=0;pilha.valores.size()>i;i++){
			conteudo+=pilha.valores.get(i);
			conteudo+="\n";
			
		}
		JOptionPane.showMessageDialog(null, conteudo, "Histórico.", JOptionPane.PLAIN_MESSAGE);
		
	}

	public void processaWindowClosing() {
		SalvaArquivo salva = new SalvaArquivo();
		String conteudo="";
		for(int i=0;pilha.valores.size()>i;i++){
			conteudo+=pilha.valores.get(i);
		}	
		try {
			String Data =new SimpleDateFormat("dd-MM-yyyy_h-m-s").format(new Date());
			salva.salvar(conteudo,Data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ProcessaRedo() {
		// TODO Auto-generated method stub
		
	}

}
