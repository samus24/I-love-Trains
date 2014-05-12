package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Controlador.Controlador;

public class Principal implements ActionListener
{
	private JPanel panelIzquierdo, panelDerecho, panelPrincipal;
	private JLabel etiquetaMapa;
	private Border borde;
	private BarraMenu barraMenu;
	private Trenes appTrenes;
	private UIsignal senales;
	private Controlador controlador;
	
	public Principal (Controlador controlador) {
		this.controlador = controlador;
		borde = BorderFactory.createCompoundBorder();
		
		barraMenu = new BarraMenu(); // esto no necesita controlador, no?
		etiquetaMapa = new JLabel("Aqui va el mapa");
		appTrenes = new Trenes(this.controlador);
		senales = new UIsignal(this.controlador);
	}
	
	public JPanel crearPanelPrincipal()
	{
		panelPrincipal = new JPanel(new BorderLayout());
		panelIzquierdo = new JPanel(new CardLayout());
		panelDerecho = new Mapa(controlador);
		
		//Creamos paneles lado Izquierdo
		
		panelIzquierdo.add(crearPanel(Color.red, 300,600),"pVacio");
		panelIzquierdo.add(cargarPanelTrenes(appTrenes),"pTrenes");
		panelIzquierdo.add(cargarPanelSenales(senales),"pSenales");
		
		//A�adimos paneles al principal
		
		panelPrincipal.add(panelIzquierdo,BorderLayout.LINE_START);
		panelPrincipal.add(panelDerecho,BorderLayout.CENTER);
		
		barraMenu.opcionTrenes.addActionListener(this);
		barraMenu.opcionSenales.addActionListener(this);
		barraMenu.opcionPagPrincipal.addActionListener(this);
		
		return panelPrincipal;
	}
	
	public JPanel cargarPanelTrenes(Trenes trenes)
	{
		JPanel panel = new JPanel();
		panel = trenes.crearPreferenciaTrenes();
		panel.setBorder(this.borde);
		
		return panel;
	}
	
	public JPanel cargarPanelSenales(UIsignal senales)
	{
		JPanel panel = new JPanel();
		panel = senales;
		panel.setBorder(this.borde);

		return panel;
	}
	
	public void crearYMostrarGUI() {
		JFrame frame = new JFrame("Interfaz IS");
		Principal principal = new Principal(controlador);
		
		frame.setContentPane(principal.crearPanelPrincipal());
		frame.setJMenuBar(principal.barraMenu.crearBarraMenu());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,700);
		frame.setMinimumSize(new Dimension(1000,700));
		frame.pack();
		frame.setVisible(true);
	} 
	
	public JPanel crearPanel(Color color, int x, int y) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(x, y));
		panel.setBackground(color);
		panel.setBorder(this.borde);
		return panel;
	}
	
	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout) (panelIzquierdo.getLayout());
		if(e.getSource() == barraMenu.opcionTrenes)
		{
			cl.show(panelIzquierdo, "pTrenes");
		}
		else if(e.getSource() == barraMenu.opcionSenales)
		{
			cl.show(panelIzquierdo, "pSenales");
		}
		else if(e.getSource() == barraMenu.opcionPagPrincipal)
		{
			cl.show(panelIzquierdo, "pVacio");
		}
	}
	
	/*public static void main(String [] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				crearYMostrarGUI();
				
			}
		});
	}*/
}
