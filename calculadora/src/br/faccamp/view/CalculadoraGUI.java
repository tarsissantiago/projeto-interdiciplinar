package br.faccamp.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.faccamp.domain.Calculadora;
import javax.swing.SwingConstants;

public class CalculadoraGUI {
	private JFrame frame;
	private JTextField display;
	private Calculadora calculadora;

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public CalculadoraGUI(Calculadora calculadora) {
		this.calculadora = calculadora;
		initialize();
		getFrame().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		createMainFrame();
		createButtons();
		createMenuBar();
		createKeyEvent();
	}

	private void createKeyEvent() {
		frame.addKeyListener(new KeyListener() {

			/*
			 * Evento do teclado
			 */

			public void keyTyped(KeyEvent e) {
				
			}
			
			public void keyReleased(KeyEvent event) {
			}

			public void keyPressed(KeyEvent ke) {
				 
		            if (ke.isControlDown()){
		            	if (ke.getKeyCode() == KeyEvent.VK_C) 
		            	calculadora.ProcessaColar();
		            	if (ke.getKeyCode() == KeyEvent.VK_V)
		            		calculadora.ProcessaCopiar();
		            }
				switch (ke.getKeyCode()) {
				
				
				case 8:
					calculadora.processaBackSpace();
					break;
				case 27:
					calculadora.processaC();
					break;
					// *****numeros****
				case 96:
				case 48:
					calculadora.processaZero();
					break;
				case 97:
				case 49:
					calculadora.processaUm();
					break;
				case 98:
				case 50:
					calculadora.processaDois();
					break;
				case 99:
				case 51:
					calculadora.processaTres();
					break;
				case 100:
				case 52:
					calculadora.processaQuatro();
					break;
				case 101:
				case 53:
					calculadora.processaCinco();
					break;
				case 102:
				case 54:
					calculadora.processaSeis();
					break;
				case 103:
				case 55:
					calculadora.processaSete();
					break;
				case 104:
				case 56:
					calculadora.processaOito();
					break;
				case 105:
				case 57:
					calculadora.processaNove();
					break;
				// ******operadores**********
				case 111:
					calculadora.processaDivisao();
					break;
				case 109:
					calculadora.processaMenos();
					break;
				case 107:
					calculadora.processaMais();
					break;
				case 106:
					calculadora.processaVezes();
					break;
				case 10:
					calculadora.processaIgual();
					break;
				case 0:
				case 46:
				case 110:
					calculadora.processaVirgula();
					break;

				}

			}

		});

	}

	private void createMenuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu edit = new JMenu("Editar");
		JMenuItem copiar = new JMenuItem("    Copiar Ctrl+v    ");
		copiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculadora.ProcessaCopiar();
			}
		});

		JMenuItem colar = new JMenuItem("    Colar Ctrl+c    ");
		colar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculadora.ProcessaColar();
			}
		});

		edit.add(copiar);
		edit.add(colar);
		bar.add(edit);
		
		JMenu avancado = new JMenu("  Avançado  ");
		JMenuItem historico = new JMenuItem("    Mostrar Histórico    ");
		historico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				calculadora.processaHistorico();
			}
		});
		avancado.add(historico);
		JMenuItem sobre = new JMenuItem("    Sobre    ");
		sobre.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			calculadora.processaSobre();
				
			}
		});
		avancado.add(sobre);
		bar.add(avancado);
		bar.setSize(1000, 20);
		frame.add(bar);

	}

	private void createButtons() {

		JButton buttonMC = new JButton("MC");
		buttonMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMC();
			}
		});
		buttonMC.setBounds(45, 89, 63, 39);
		buttonMC.setFocusable(false);
		frame.getContentPane().add(buttonMC);
		display = new JTextField("0");
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setBounds(112, 25, 210, 56);
		frame.getContentPane().add(display);
		display.setColumns(10);
		display.setEditable(false);
		display.setFont(new Font("", 45, 35));
		
		JButton buttonMR = new JButton("MR");
		buttonMR.setFocusable(false);
		buttonMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMR();
			}
		});
		buttonMR.setBounds(115, 89, 63, 39);
		frame.getContentPane().add(buttonMR);

		JButton btnMS = new JButton("MS");
		btnMS.setFocusable(false);
		btnMS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculadora.processaMS();
			}
		});
		btnMS.setBounds(185, 89, 63, 39);
		frame.getContentPane().add(btnMS);

		JButton btnMMais = new JButton("M+");
		btnMMais.setFocusable(false);
		btnMMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMMais();
			}
		});
		btnMMais.setBounds(255, 89, 63, 39);
		frame.getContentPane().add(btnMMais);

		JButton btnMMenos = new JButton("M-");
		btnMMenos.setFocusable(false);
		btnMMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMMenos();
			}
		});
		btnMMenos.setBounds(325, 89, 63, 39);
		frame.getContentPane().add(btnMMenos);

		JButton btnCE = new JButton("CE");
		btnCE.setFocusable(false);
		btnCE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaCE();
			}
		});
		btnCE.setBounds(45, 130, 63, 39);
		frame.getContentPane().add(btnCE);

		JButton btnC = new JButton("C");
		btnC.setFocusable(false);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaC();
			}
		});
		btnC.setBounds(115, 130, 63, 39);
		frame.getContentPane().add(btnC);

		JButton btnRaiz = new JButton("Raiz");
		btnRaiz.setFocusable(false);
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaRaiz();
			}
		});
		btnRaiz.setBounds(255, 130, 63, 39);
		frame.getContentPane().add(btnRaiz);

		JButton buttonMaisOuMenos = new JButton("+/-");
		buttonMaisOuMenos.setFocusable(false);
		buttonMaisOuMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMaisOuMenos();
			}
		});
		buttonMaisOuMenos.setBounds(185, 130, 63, 39);
		frame.getContentPane().add(buttonMaisOuMenos);

		JButton btnFatorial = new JButton("n!");
		btnFatorial.setFocusable(false);
		btnFatorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaFatorial();
			}
		});
		btnFatorial.setBounds(325, 130, 63, 39);
		frame.getContentPane().add(btnFatorial);

		JButton buttonSete = new JButton("7");
		buttonSete.setFocusable(false);
		buttonSete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaSete();
			}
		});
		buttonSete.setBounds(45, 176, 63, 39);
		frame.getContentPane().add(buttonSete);

		JButton buttonOito = new JButton("8");
		buttonOito.setFocusable(false);
		buttonOito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaOito();
			}
		});
		buttonOito.setBounds(115, 176, 63, 39);
		frame.getContentPane().add(buttonOito);

		JButton buttonNove = new JButton("9");
		buttonNove.setFocusable(false);
		buttonNove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaNove();
			}
		});
		buttonNove.setBounds(185, 176, 63, 39);
		frame.getContentPane().add(buttonNove);

		JButton buttonDivisao = new JButton("/");
		buttonDivisao.setFocusable(false);
		buttonDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaDivisao();
			}
		});
		buttonDivisao.setBounds(255, 176, 63, 39);
		frame.getContentPane().add(buttonDivisao);

		JButton buttonPercentual = new JButton("%");
		buttonPercentual.setFocusable(false);
		buttonPercentual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaPorcentual();
			}
		});
		buttonPercentual.setBounds(325, 176, 63, 39);
		frame.getContentPane().add(buttonPercentual);

		JButton buttonQuatro = new JButton("4");
		buttonQuatro.setFocusable(false);
		buttonQuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaQuatro();
			}
		});
		buttonQuatro.setBounds(45, 222, 63, 39);
		frame.getContentPane().add(buttonQuatro);

		JButton buttonCinco = new JButton("5");
		buttonCinco.setFocusable(false);
		buttonCinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaCinco();
			}
		});
		buttonCinco.setBounds(115, 222, 63, 39);
		frame.getContentPane().add(buttonCinco);

		JButton buttonSeis = new JButton("6");
		buttonSeis.setFocusable(false);
		buttonSeis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaSeis();
			}
		});
		buttonSeis.setBounds(185, 222, 63, 39);
		frame.getContentPane().add(buttonSeis);

		JButton buttonVezes = new JButton("*");
		buttonVezes.setFocusable(false);
		buttonVezes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaVezes();
			}
		});
		buttonVezes.setBounds(255, 222, 63, 39);
		frame.getContentPane().add(buttonVezes);

		JButton btnUmSobreX = new JButton("1/x");
		btnUmSobreX.setFocusable(false);
		btnUmSobreX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaUmSobreX();
			}
		});
		btnUmSobreX.setBounds(325, 222, 63, 39);
		frame.getContentPane().add(btnUmSobreX);

		JButton buttonUm = new JButton("1");
		buttonUm.setFocusable(false);
		buttonUm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaUm();
			}
		});
		buttonUm.setBounds(45, 268, 63, 39);
		frame.getContentPane().add(buttonUm);

		JButton buttonDois = new JButton("2");
		buttonDois.setFocusable(false);
		buttonDois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaDois();
			}
		});
		buttonDois.setBounds(115, 268, 63, 39);
		frame.getContentPane().add(buttonDois);

		JButton buttonTres = new JButton("3");
		buttonTres.setFocusable(false);
		buttonTres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaTres();
			}
		});
		buttonTres.setBounds(185, 268, 63, 39);
		frame.getContentPane().add(buttonTres);

		JButton buttonMenos = new JButton("-");
		buttonMenos.setFocusable(false);
		buttonMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMenos();
			}
		});
		buttonMenos.setBounds(255, 268, 63, 39);
		frame.getContentPane().add(buttonMenos);

		JButton btnXElevadoY = new JButton("x^y");
		btnXElevadoY.setFocusable(false);
		btnXElevadoY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaXElevadoY();
			}
		});
		btnXElevadoY.setBounds(325, 268, 63, 39);
		frame.getContentPane().add(btnXElevadoY);

		JButton buttonZero = new JButton("0");
		buttonZero.setFocusable(false);
		buttonZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaZero();
			}
		});
		buttonZero.setBounds(45, 314, 63, 39);
		frame.getContentPane().add(buttonZero);

		JButton buttonVirgula = new JButton(".");
		buttonVirgula.setFocusable(false);
		buttonVirgula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaVirgula();
			}
		});
		buttonVirgula.setBounds(115, 314, 63, 39);
		frame.getContentPane().add(buttonVirgula);

		JButton buttonIgual = new JButton("=");
		buttonIgual.setFocusable(false);
		buttonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaIgual();
			}
		});
		buttonIgual.setBounds(185, 314, 63, 39);
		frame.getContentPane().add(buttonIgual);

		JButton buttonMais = new JButton("+");
		buttonMais.setFocusable(false);
		buttonMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaMais();
			}
		});
		buttonMais.setBounds(255, 314, 63, 39);
		frame.getContentPane().add(buttonMais);

		JButton btnLog = new JButton("log");
		btnLog.setFocusable(false);
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculadora.processaLog();
			}
		});
		btnLog.setBounds(325, 314, 63, 39);
		frame.getContentPane().add(btnLog);

		JButton buttonUndo = new JButton("Undo");
		buttonUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculadora.processaUndo();
			}
		});
		buttonUndo.setBounds(45, 34, 63, 39);
		buttonUndo.setFocusable(false);
		frame.getContentPane().add(buttonUndo);

		JButton buttonRedo = new JButton("Redo");
		buttonRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculadora.ProcessaRedo();
			}
		});
		buttonRedo.setBounds(325, 34, 63, 39);
		buttonRedo.setFocusable(false);
		frame.getContentPane().add(buttonRedo);
	}

	private void createMainFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Calculadora");
		frame.setResizable(false);
		frame.setFocusable(true);
		ImageIcon ico = new ImageIcon("calc.png");
		Image image = ico.getImage();
		frame.setIconImage(image);
		frame.addWindowListener(new WindowAdapter(){ 
			    public void windowClosing (WindowEvent e) {
			    	calculadora.processaWindowClosing();
			      JOptionPane.showMessageDialog(null,"Um arquivo Csv foi salvo.",
			"Calculadora.",JOptionPane.PLAIN_MESSAGE);

			System.exit(0);
			}
	});
	}

	public void atualizaDisplay(String texto) {
		if (texto.length() < 10)
			display.setFont(new Font("", 45, 35));
		else if (texto.length() < 13)
			display.setFont(new Font("", 35, 25));
		else if (texto.length() < 16)
			display.setFont(new Font("", 30, 20));
		else
			display.setFont(new Font("", 25, 15));

		display.setText(texto);
	}

	public String getDisplay() {
		return display.getText();
	}
}
