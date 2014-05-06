package Vista;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.Controlador;


public class Trenes implements ActionListener {
	private JTextField trayecto;
	private JTextField numVagones;
	private JButton  eliminar;
	private JButton cambiar;
	private JLabel vagones;
	private JLabel titulo;
	private JLabel tren;
	private JButton crear;
	private Controlador controlador;
	
	public Trenes(Controlador controlador) {
		trayecto = new JTextField();
		numVagones = new JTextField();
		eliminar = new JButton("Eliminar");;
		cambiar = new JButton("Cambiar");
		vagones = new JLabel("Nº Vagones:");
		titulo = new JLabel("-- TRENES --");
		tren = new JLabel("Tren:");
		crear = new JButton("Crear");
		this.controlador = controlador;
	}
	
	public JPanel crearPreferenciaTrenes(/*pasar el vector de trenes*/) {
		JPanel prefTrenes = new JPanel(new BorderLayout(2,2));
		prefTrenes.setLayout(null);
		
		prefTrenes.setPreferredSize(new Dimension(300,600));
		
		prefTrenes.add(titulo);
		prefTrenes.add(crear);
		prefTrenes.add(vagones);
		prefTrenes.add(tren);
		prefTrenes.add(trayecto);
		prefTrenes.add(numVagones);
		prefTrenes.add(eliminar);
		prefTrenes.add(cambiar);
		
		titulo.setLocation(120,0);
		titulo.setSize(90, 30);
		
		tren.setLocation(10, 40);
		tren.setSize(50, 20);
		
		trayecto.setLocation(85, 40);
		trayecto.setSize(100, 20);
		trayecto.setText("A-B");
		trayecto.setHorizontalAlignment(JTextField.CENTER);
		
		
		eliminar.setLocation(200, 40);
		eliminar.setSize(90, 20);
		eliminar.addActionListener(this);
		
		vagones.setLocation(10, 80);
		vagones.setSize(150, 20);
		
		numVagones.setLocation(85, 80);
		numVagones.setSize(100, 20);
		numVagones.setText("5");
		numVagones.setHorizontalAlignment(JTextField.CENTER);
		
		cambiar.setLocation(200, 80);
		cambiar.setSize(90, 20);
		cambiar.addActionListener(this);
		
		
		crear.setLocation(10, 130);
		crear.setSize(100, 20);
		crear.addActionListener(this);
		
		
		return prefTrenes;
	}

	public void actionPerformed(ActionEvent e) {
		if ( e.getSource() == eliminar ) {
			controlador.eliminarTren(); //if(si tira error, mostrarlo con un system.err)
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"TREN ELIMINADO", "ATENCION!!",JOptionPane.WARNING_MESSAGE);	
		}
		
		if ( e.getSource() == crear ) {
			controlador.crearTren(1); //recibe vagones de la vista
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame,"TREN CREADO","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
		
		if ( e.getSource() == cambiar ) {
			controlador.modificarTren(1, 1); // recibe el id y el numero de vagones de la vista
			JFrame frame = new JFrame(); 
			JOptionPane.showMessageDialog(frame,"TREN MODIFICADO","Informacion",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
