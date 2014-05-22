package Vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Controlador.Controlador;
import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Senal;

@SuppressWarnings("serial")
public class UIsignal extends JPanel {
	private Controlador controlador;
	/////////////////////////////////////////////
	private JTable tabla;
	private TablaSenales datosSenales;
	private int filaSeleccionada;

	public UIsignal(Controlador controlador) {
		this.filaSeleccionada=-1;
		this.controlador=controlador;
		crearVista();
	}


	private void crearVista() {
		// TODO Auto-generated method stub

		JButton anyadir= new JButton("Nuevo");
		JButton cambiar= new JButton("Cambiar");
		JButton eliminar = new JButton("Eliminar");

		JPanel botones= new JPanel(new FlowLayout());


		this.setBorder(BorderFactory.createTitledBorder("Se�ales"));
		this.datosSenales=new TablaSenales();
		this.tabla = new JTable(datosSenales); 
		JScrollPane tablaReal = new JScrollPane(this.tabla);
		this.tabla.setPreferredScrollableViewportSize(new Dimension(500, 550));	

		this.setLayout(new BorderLayout());
		this.add(botones,BorderLayout.PAGE_START);
		this.add(tablaReal,BorderLayout.PAGE_END);
		botones.add(anyadir);
		botones.add(cambiar);
		botones.add(eliminar);

		anyadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarNuevoFormulario();
			}
		});

		cambiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarCambiarFormulario();
			}
		});

		eliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mostrarEliminarFormulario();
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
				int tam_datos=datosSenales.getRowCount();					
				if((tam_datos > 0) && (tabla.getSelectedRow() != -1))
					filaSeleccionada=(int) datosSenales.getValueAt(tabla.getSelectedRow(), 0);
			}
		});

		/////////////////////////////////////////////////////////////	

		updateView();
	}


	protected void mostrarEliminarFormulario() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		final JDialog dialog = new JDialog();
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				dialog.setTitle("Eliminar Se�al");
				dialog.setVisible(true);
				dialog.setLocation(400, 230);
				dialog.setPreferredSize(new java.awt.Dimension(400, 300));
				dialog.setLayout(new FlowLayout());
				dialog.pack();
				JLabel id = new JLabel("�Eliminar Senal con id: ("+ filaSeleccionada+ ") ?");
				final Senal mod=controlador.getSenales().get(filaSeleccionada);
				JButton ok = new JButton("Aceptar");
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub				
						controlador.eliminarSenal(filaSeleccionada,mod.getCoordenada());
						updateView();
						Principal.actualizarMapa();
						filaSeleccionada =-1;					
					}
				});


				JButton cancel = new JButton("Cancelar");
				ok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						dialog.setVisible(false);
					}
				});
				dialog.add(id);
				dialog.add(ok);
				dialog.add(cancel);
			}
		});	

	}


	protected void mostrarCambiarFormulario() {
		// TODO Auto-generated method stub
		final JDialog dialog = new JDialog();
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dialog.setTitle("Nuevo Tren");
				dialog.setVisible(true);
				dialog.setLocation(400, 230);
				dialog.setPreferredSize(new java.awt.Dimension(400, 300));
				dialog.setLayout(new FlowLayout());
				dialog.pack();

				Senal mod=controlador.getSenales().get(filaSeleccionada);
				JLabel titulo = new JLabel("Cambiar el Estado de la se�al (ROJO/VERDE)?");
				JLabel id = new JLabel("Id: ");
				JTextField idText = new JTextField(10);		
				idText.setText(""+filaSeleccionada);
				idText.setEditable(false);

				JLabel coordenada = new JLabel("Coordenada: ");
				JLabel xl = new JLabel("x: ");
				final JTextField x = new JTextField(5);
				x.setText(""+mod.getCoordenada().getCoordenadaX());
				JLabel yl = new JLabel("y: ");
				x.setEditable(false);
				final JTextField y = new JTextField(5);	
				y.setText(""+mod.getCoordenada().getCoordenadaY());
				y.setEditable(false);
				JLabel estadoLabel = new JLabel("Estado: ");
				final JTextField estado = new JTextField(5);
				estado.setText(""+mod.getEstado()); //por defecto
				estado.setEditable(false);


				JButton ok = new JButton("Cambiar");
				final int idMod=filaSeleccionada;
				ok.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try{
							Coordenada c = new Coordenada(Integer.parseInt(x.getText()), Integer.parseInt(y.getText()));
							controlador.modificarSenal(idMod,c);
							updateView();
							Principal.actualizarMapa();
							dialog.setVisible(false);
						}catch(NumberFormatException e1){
							JOptionPane.showMessageDialog(null, new JTextArea("Has introducido una cadena en el campo coordenada"));
						}
					}
				});
				JButton cancel = new JButton("Cancelar");
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}
				});
				dialog.add(titulo);
				dialog.add(id);
				dialog.add(coordenada);
				dialog.add(xl);dialog.add(x);
				dialog.add(yl);dialog.add(y);
				dialog.add(estadoLabel);dialog.add(estado);
				dialog.add(ok);
				dialog.add(cancel);		
			}
		});
		
	}


	protected void mostrarNuevoFormulario() {
		// TODO Auto-generated method stub
		final JDialog dialog = new JDialog();
SwingUtilities.invokeLater(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		dialog.setTitle("Nueva se�al");
		dialog.setVisible(true);
		dialog.setLocation(400, 230);
		dialog.setPreferredSize(new java.awt.Dimension(400, 300));
		dialog.setLayout(new FlowLayout());
		dialog.pack();

		JLabel id = new JLabel("Id: ");
		JTextField idText = new JTextField(10);		
		idText.setText(""+controlador.getSenales().size());
		idText.setEditable(false);

		JLabel coordenada = new JLabel("Coordenada: ");
		JLabel xl = new JLabel("x: ");
		final JTextField x = new JTextField(5);
		JLabel yl = new JLabel("y: ");
		final JTextField y = new JTextField(5);	

		JLabel estadoLabel = new JLabel("Estado: ");
		final JTextField estado = new JTextField(5);
		estado.setText("ROJO"); //por defecto
		estado.setEditable(false);


		JButton ok = new JButton("Crear");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Coordenada c = new Coordenada(Integer.parseInt(y.getText()), Integer.parseInt(x.getText()));
					controlador.anadirSenal(c, EstadoSenal.ROJO);
					Principal.actualizarMapa();
					updateView();
					dialog.setVisible(false);
				}catch(NumberFormatException e1){
					JOptionPane.showMessageDialog(null, new JTextArea("Has introducido una cadena en el campo coordenada"));
				}
			}
		});
		JButton cancel = new JButton("Cancelar");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
			}
		});

		dialog.add(id);
		dialog.add(coordenada);
		dialog.add(xl);dialog.add(x);
		dialog.add(yl);dialog.add(y);
		dialog.add(estadoLabel);dialog.add(estado);
		dialog.add(ok);
		dialog.add(cancel);
	}
});
		
	}


	public void updateView(){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub

				datosSenales.refresh(controlador.getSenales());
			}
		});
	}
}
