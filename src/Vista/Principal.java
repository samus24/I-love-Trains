/*
 Calidad: Las llaves de apertura de bloque no estan colocadas a continuaci—n
 del nombre del metodo/clase
 
 Codigo comentado que no a–ade funcionalidad.
 
 Uso de variables con nombres que tienen caracteres especiales (–)
 
 Corregido: .
 
 */

package pruebas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Principal implements ActionListener {
	private JPanel panelIzquierdo, panelDerecho, panelPrincipal;
	private JLabel etiquetaMapa;
	private Border borde;
	private BarraMenu barraMenu;
	private Trenes appTrenes;
	
	public Principal() {
		borde = BorderFactory.createCompoundBorder();
		barraMenu = new BarraMenu();
		etiquetaMapa = new JLabel("Aquí va el mapa");
		appTrenes = new Trenes();
	}
	
	public JPanel crearPanelPrincipal() {
		panelPrincipal = new JPanel(new BorderLayout(2,2));
		
		panelIzquierdo = crearPanel(Color.red, 300, 600);
		
		panelDerecho = crearPanel(Color.blue, 700, 600);
		etiquetaMapa.setForeground(Color.BLACK);
		panelDerecho.add(etiquetaMapa);
		
		panelPrincipal.add(panelIzquierdo,BorderLayout.LINE_START);
		panelPrincipal.add(panelDerecho,BorderLayout.CENTER);
	
		barraMenu.opcionTrenes.addActionListener(this);
		barraMenu.opcionSenales.addActionListener(this);
		
		panelPrincipal.setOpaque(true);
		return panelPrincipal;
	}
	
	public JPanel cargarPanelTrenes(Trenes panelTrenes, JPanel panelMapa) {
		panelIzquierdo = panelTrenes.crearPreferenciaTrenes();
		panelIzquierdo.setBorder(this.borde);

		panelDerecho = crearPanel(Color.blue, 700, 600);
		etiquetaMapa.setForeground(Color.BLACK);
		panelDerecho.add(etiquetaMapa);

		panelPrincipal.add(panelIzquierdo,BorderLayout.LINE_START);
		panelPrincipal.add(panelDerecho,BorderLayout.CENTER);
	
		barraMenu.opcionTrenes.addActionListener(this);
		barraMenu.opcionSenales.addActionListener(this);
		
		panelPrincipal.setOpaque(true);
		return panelPrincipal;
	}
	
	
	private static void crearYMostrarGUI() {
		JFrame frame = new JFrame("Interfaz IS");
		Principal principal = new Principal();
		frame.setContentPane(principal.crearPanelPrincipal());
		frame.setJMenuBar(principal.barraMenu.crearBarraMenu());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setMinimumSize(new Dimension(1000,700));
		frame.setVisible(true);
	} 
	
	private JPanel crearPanel(Color color, int x, int y) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(x, y));
		panel.setBackground(color);
		panel.setBorder(this.borde);
		return panel;
	}
	
	private void limpiarPantalla() {
		panelIzquierdo.setVisible(false);
		panelDerecho.setVisible(false);
		panelPrincipal.remove(panelIzquierdo);
		panelPrincipal.remove(panelDerecho);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == barraMenu.opcionTrenes) {
			limpiarPantalla();
			cargarPanelTrenes(appTrenes, panelDerecho);
		}
		else if(e.getSource() == barraMenu.opcionSenales) {
			limpiarPantalla();	
		}
	}
	
	public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				crearYMostrarGUI();
				
			}
		});
	}
}
