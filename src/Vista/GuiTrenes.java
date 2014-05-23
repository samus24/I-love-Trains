package Vista;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Modelo.Coordenada;
import Modelo.Trayecto;
import Modelo.Tren;
import Utiles.Constantes;


@SuppressWarnings("serial")
public class GuiTrenes extends JPanel{
	private Controlador controlador;
	private JTable tabla;
	private TablaTrenes datosTrenes;
	private int filaSeleccionada;


	public GuiTrenes(Controlador controlador) {
		this.controlador = controlador;
		this.filaSeleccionada=-1;
		crearVista();
	}

	public void crearVista() {
		this.setBorder(BorderFactory.createTitledBorder("Trenes"));
		this.datosTrenes=new TablaTrenes();
		this.tabla = new JTable(datosTrenes); 
		JScrollPane tablaReal = new JScrollPane(this.tabla);
		this.tabla.setPreferredScrollableViewportSize(new Dimension(500, 550));	

		JButton anyadir= new JButton("Nuevo");
		JButton modificar= new JButton("Modificar");
		JButton eliminar = new JButton("Eliminar");

		JPanel botones= new JPanel(new FlowLayout());
		botones.add(anyadir);
		botones.add(modificar);
		botones.add(eliminar);

		anyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarNuevoFormulario();
			}
		});

		modificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(filaSeleccionada != -1){
					mostrarModificarFormulario();
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila");
			}
		});
		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(filaSeleccionada != -1){
					mostrarEliminarFormulario();
				}
				else
					JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila");
			}
		});

		/////////////Listener Tabla///////////////////////////////		
		this.tabla.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {				
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int tam_datos=datosTrenes.getRowCount();					
				if((tam_datos > 0) && (tabla.getSelectedRow() != -1))
					filaSeleccionada=(int) datosTrenes.getValueAt(tabla.getSelectedRow(), 0);
			}
		});

		/////////////////////////////////////////////////////////////	
		this.setLayout(new BorderLayout());
		this.add(botones,BorderLayout.PAGE_START);
		this.add(tablaReal,BorderLayout.PAGE_END);

		updateView();
	}

	public void mostrarEliminarFormulario() {
		final JDialog dialog = new JDialog();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				dialog.setTitle("Eliminar Tren");
				dialog.setVisible(true);
				dialog.setLocation(400, 230);
				dialog.setPreferredSize(new java.awt.Dimension(200, 215));
				dialog.setLayout(new FlowLayout());
				dialog.pack();
				JLabel id = new JLabel("¿Eliminar tren con id: ("+ filaSeleccionada+ ") ?");

				JButton ok = new JButton("Aceptar");

				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {			
						controlador.eliminarTren(filaSeleccionada);
						updateView();
						Principal.actualizarMapa();
						filaSeleccionada =-1;	
						dialog.setVisible(false);
					}
				});

				ImageIcon icon = new ImageIcon("src/Vista/images/eliminar.png");
				JLabel image = new JLabel(icon);

				JButton cancel = new JButton("Cancelar");
				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dialog.setVisible(false);
					}
				});
				dialog.add(image);
				dialog.add(id);
				dialog.add(ok);
				dialog.add(cancel);

			}
		});

	}

	public void mostrarModificarFormulario() {
		final JDialog dialog = new JDialog();
		SwingUtilities.invokeLater(new Runnable() {

			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				final Tren modTren= controlador.getTrenes().get(filaSeleccionada);
				dialog.setTitle("Modificar Tren");
				dialog.setVisible(true);
				dialog.setLocation(400, 230);
				dialog.setPreferredSize(new java.awt.Dimension(400, 230));
				dialog.setLayout(new FlowLayout());
				dialog.pack();

				JLabel id = new JLabel("Id: ");
				JTextField idText = new JTextField(10);		
				idText.setText(""+filaSeleccionada);
				idText.setEditable(false);

				JLabel coordenada = new JLabel("Coordenada: ");

				JLabel xl = new JLabel("x: ");
				final JTextField x = new JTextField(5);
				x.setText(""+modTren.getCoordenadaInicio().getCoordenadaY());
				x.setEditable(false);

				JLabel yl = new JLabel("y: ");
				final JTextField y = new JTextField(5);	
				y.setText(""+modTren.getCoordenadaInicio().getCoordenadaX());
				y.setEditable(false);

				JLabel vl = new JLabel("Nº Vagones: ");
				final JTextField nVagones = new JTextField(5);	
				nVagones.setText(""+modTren.getVagones());

				JLabel ltr= new JLabel("Trayecto:");
				@SuppressWarnings("rawtypes")
				final JComboBox trayecto = new JComboBox();
				trayecto.addItem(modTren.getTrayecto());
				trayecto.setEditable(false);

				JButton ok = new JButton("Modificar");
				final Integer modificarV= filaSeleccionada;
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Integer numeroVagones=null;
						try{
							numeroVagones= Integer.parseInt(nVagones.getText());
							controlador.modificarTren(modificarV, numeroVagones);
							updateView();
							dialog.setVisible(false);
							Principal.actualizarMapa();

						}catch(NumberFormatException e2){
							JOptionPane.showMessageDialog(null,"Has introducido una cadena en el campo vagones");
						}
					}
				});
				JButton cancel = new JButton("Cancelar");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});

				ImageIcon icon = new ImageIcon("src/Vista/images/modificar.png");
				JLabel image = new JLabel(icon);


				dialog.add(id);
				dialog.add(idText);
				dialog.add(coordenada);
				dialog.add(xl);dialog.add(x);
				dialog.add(yl);dialog.add(y);
				dialog.add(ltr);
				dialog.add(trayecto);		
				dialog.add(vl);
				dialog.add(nVagones);
				dialog.add(ok);
				dialog.add(cancel);
				dialog.add(image);
				filaSeleccionada=-1;
			}
		});

	}

	public void mostrarNuevoFormulario() {
		final JDialog dialog = new JDialog();
		SwingUtilities.invokeLater(new Runnable() {

			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void run() {
				dialog.setTitle("Nuevo Tren");
				dialog.setVisible(true);
				dialog.setLocation(400, 230);
				dialog.setPreferredSize(new java.awt.Dimension(400, 270));
				dialog.setLayout(new FlowLayout());
				dialog.pack();

				JLabel id = new JLabel("Id: ");
				JTextField idText = new JTextField(10);		
				idText.setText(""+controlador.getTrenes().size());
				idText.setEditable(false);

				JLabel coordenada = new JLabel("Coordenada: ");
				JLabel xl = new JLabel("x: ");
				final JTextField x = new JTextField(5);
				JLabel yl = new JLabel("y: ");
				final JTextField y = new JTextField(5);	

				JLabel vl = new JLabel("Nº Vagones: ");
				final JTextField nVagones = new JTextField(5);	

				JLabel ltr= new JLabel("Trayecto:");
				final JComboBox trayecto = new JComboBox();
				trayecto.addItem("--Elegir trayecto--");
				trayecto.addItem("Horizontal-Derecha");
				trayecto.addItem("Horizontal-Izquierda");
				trayecto.addItem("Vertical-Arriba");
				trayecto.addItem("Vertical-Abajo");


				JButton ok = new JButton("Crear");
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						boolean correcto=true;
						boolean correctoC=true;
						Coordenada c = null;

						try{
							c = new Coordenada(Integer.parseInt(y.getText()), Integer.parseInt(x.getText()));
						}catch(NumberFormatException e1){
							JOptionPane.showMessageDialog(null, "Has introducido una cadena en el campo coordenada");
							correcto=false;
						}

						Trayecto anyadirTrayecto = null;
						switch (trayecto.getSelectedItem().toString()) {
						case "Horizontal-Derecha":anyadirTrayecto=Trayecto.HorizontalDerecha;break;					
						case "Horizontal-Izquierda":anyadirTrayecto=Trayecto.HorizontalIzquierda;break;
						case "Vertical-Abajo":anyadirTrayecto=Trayecto.VerticalAbajo;break;
						case "Vertical-Arriba":anyadirTrayecto=Trayecto.VerticalArriba;break;

						default:JOptionPane.showMessageDialog(null,"Selecciona un trayecto.!");
						correcto=false;	break;
						}
						Integer numeroVagones=null;
						try{
							numeroVagones= Integer.parseInt(nVagones.getText());
						}catch(NumberFormatException e2){
							JOptionPane.showMessageDialog(null,"Has introducido una cadena en el campo vagones");
							correcto=false;
						}
						if(correcto){
							char[][] mundo = controlador.getEstadoMundo();
							if(numeroVagones + c.getCoordenadaX() > Constantes.DIMENSION_MAPA_X || c.getCoordenadaX() - numeroVagones< 0   
									|| numeroVagones + c.getCoordenadaY() > Constantes.DIMENSION_MAPA_Y ||  c.getCoordenadaY() - numeroVagones  < 0)
								correctoC=false;
							if(correctoC && mundo[c.getCoordenadaX()][c.getCoordenadaY()] != 'c' ) correctoC=false;
							if(correctoC){
								for(int i = numeroVagones; i>0 && correcto; i--){
									switch (anyadirTrayecto) {
									case HorizontalDerecha:
										if(mundo[c.getCoordenadaX()][c.getCoordenadaY()-i] != 'c') correctoC=false;


										break;
									case HorizontalIzquierda:
										if(mundo[c.getCoordenadaX()][c.getCoordenadaY()+i] != 'c') correctoC=false;	

										break;
									case VerticalAbajo:
										if(mundo[c.getCoordenadaX()-i][c.getCoordenadaY()] != 'c') correctoC=false;	

										break;
									case VerticalArriba:
										if(mundo[c.getCoordenadaX()+i][c.getCoordenadaY()] != 'c') correctoC=false;

										break;


									default:
										correctoC=false;
										break;
									}			
								}
							}
						}

						if(correcto && correctoC){
							controlador.crearTren(numeroVagones, c, anyadirTrayecto);
							Principal.actualizarMapa();					
							updateView();
							dialog.setVisible(false);
						}

						else if(!correctoC) {
							JOptionPane.showMessageDialog(null,"El tren debe estar en una via");
						}

					}
				});
				JButton cancel = new JButton("Cancelar");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});

				ImageIcon icon = new ImageIcon("src/Vista/images/crear.png");
				JLabel image = new JLabel(icon);				

				dialog.add(id);
				dialog.add(idText);
				dialog.add(coordenada);
				dialog.add(xl);dialog.add(x);
				dialog.add(yl);dialog.add(y);
				dialog.add(ltr);
				dialog.add(trayecto);		
				dialog.add(vl);
				dialog.add(nVagones);
				dialog.add(ok);
				dialog.add(cancel);
				dialog.add(image);
			}
		});		


	}



	public void updateView(){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				datosTrenes.refresh(controlador.getTrenes());
			}
		});

	}
}
