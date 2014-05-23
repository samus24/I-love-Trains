package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import Controlador.Controlador;

/**
 * Construye un JPanel con un JTextArea para representar la información del mundo en un mapa de caracteres.
 * @author Miguel Angel Caballero
 */
@SuppressWarnings("serial")
public class Mapa extends JPanel {
	private Controlador contr;
	private char[][] salida;
	private JButton[][] mapa;

	public Mapa(Controlador contr) {
		this.contr = contr;
		crearVista();
	}

	public void crearVista() {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Mapa"));

		salida = contr.getEstadoMundo();
		mapa= new JButton[60][60];

		JPanel mundo = new JPanel(new GridLayout(60, 60));

		for(int i = 0; i < 60; i++){
			for(int j = 0; j < 60; j++){
				if(salida[i][j] == '*'){
					mapa[i][j]=new JButton();
					mapa[i][j].setBackground(Color.gray);					
					mundo.add(mapa[i][j]);
				}
				else{
					if(salida[i][j] == 'c'){
						mapa[i][j]=new JButton();
						mapa[i][j].setBackground(Color.DARK_GRAY);
						mapa[i][j].setSize(new Dimension(5,5));
						mundo.add(mapa[i][j]);
					}else
						if(salida[i][j] == 't'){

							mapa[i][j]=new JButton();
							mapa[i][j].setBackground(Color.YELLOW);
							mapa[i][j].setSize(new Dimension(5,5));
							mundo.add(mapa[i][j]);
						}else
							if(salida[i][j] == 'l'){

								mapa[i][j]=new JButton();
								mapa[i][j].setBackground(Color.CYAN);
								mapa[i][j].setSize(new Dimension(5,5));
								mundo.add(mapa[i][j]);
							}else
								if(salida[i][j] == 'r'){

									mapa[i][j]=new JButton();
									mapa[i][j].setBackground(Color.RED);
									mapa[i][j].setSize(new Dimension(5,5));
									mundo.add(mapa[i][j]);
								}else
									if(salida[i][j] == 'v'){

										mapa[i][j]=new JButton();
										mapa[i][j].setBackground(Color.GREEN);
										mapa[i][j].setSize(new Dimension(5,5));
										mundo.add(mapa[i][j]);
									}
									else
										if(salida[i][j] == 'i'){

											mapa[i][j]=new JButton();
											mapa[i][j].setBackground(Color.pink);
											mapa[i][j].setSize(new Dimension(5,5));
											mundo.add(mapa[i][j]);
										}else
											if(salida[i][j] == 'f'){

												mapa[i][j]=new JButton();
												mapa[i][j].setBackground(Color.pink);
												mapa[i][j].setSize(new Dimension(5,5));
												mundo.add(mapa[i][j]);
											}
				}
				mapa[i][j].setToolTipText(Integer.toString(j) + " , " + Integer.toString(i));
			}

		}
		JScrollPane panel = new JScrollPane(mundo);

		this.add(panel);
	}

	public void updateView() {
		salida = contr.getEstadoMundo();

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				for(int i = 0; i < 60; i++){
					for(int j = 0; j < 60; j++){
						if(salida[i][j] == '*'){
							mapa[i][j].setBackground(Color.gray);
						}
						else{
							if(salida[i][j] == 'c'){
								mapa[i][j].setBackground(Color.DARK_GRAY);
							}else
								if(salida[i][j] == 't'){
									mapa[i][j].setBackground(Color.YELLOW);
								}else
									if(salida[i][j] == 'l'){
										mapa[i][j].setBackground(Color.CYAN);
									}else
										if(salida[i][j] == 'r'){
											mapa[i][j].setBackground(Color.RED);
										}else
											if(salida[i][j] == 'v'){
												mapa[i][j].setBackground(Color.GREEN);
											}
											else
												if(salida[i][j] == 'i'){
													mapa[i][j].setBackground(Color.pink);
													mapa[i][j].setText("");
												}else
													if(salida[i][j] == 'f'){
														mapa[i][j].setBackground(Color.pink);
														mapa[i][j].setText("");
													}
						}
					}
				}
			}
		});

	}

}
