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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import Controlador.Controlador;

public class Principal implements ActionListener
{
	private JPanel panelIzquierdo, panelDerecho, panelPrincipal;
	private JLabel etiquetaMapa;
	private Border borde;
	private BarraMenu barraMenu;
	private Trenes appTrenes;
	private UIsignal senhales;
	private static Controlador controlador;
	
	public Principal(Controlador controlador){
		this.controlador = controlador;
		borde = BorderFactory.createCompoundBorder();
		barraMenu = new BarraMenu(this.controlador);
		etiquetaMapa = new JLabel("Aqu� va el mapa");
		appTrenes = new Trenes(this.controlador);
		senhales = new UIsignal(this.controlador);
	}
	
	public JPanel crearPanelPrincipal()
	{
		panelPrincipal = new JPanel(new BorderLayout());
		panelIzquierdo = new JPanel(new CardLayout());
		panelDerecho = crearPanel(Color.blue, 700,600);
		
		//Creamos paneles lado Izquierdo
		
		panelIzquierdo.add(crearPanel(Color.red, 300,600),"pVacio");
		panelIzquierdo.add(cargarPanelTrenes(appTrenes),"pTrenes");
		panelIzquierdo.add(cargarPanelSe�ales(senhales),"pSe�ales");
		
		//A�adimos etiqueta en panel Derecho
		
		etiquetaMapa.setForeground(Color.BLACK);
		panelDerecho.add(etiquetaMapa);
		
		//A�adimos paneles al principal
		
		panelPrincipal.add(panelIzquierdo,BorderLayout.LINE_START);
		panelPrincipal.add(panelDerecho,BorderLayout.CENTER);
		
		barraMenu.opcionTrenes.addActionListener(this);
		barraMenu.opcionSe�ales.addActionListener(this);
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
	
	public JPanel cargarPanelSe�ales(UIsignal senhales)
	{
		JPanel panel = new JPanel();
		panel = senhales;
		panel.setBorder(this.borde);

		return panel;
	}
	
	public static void crearYMostrarGUI() {
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
	
	public JPanel crearPanel(Color color, int x, int y)
	{
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(x, y));
		panel.setBackground(color);
		panel.setBorder(this.borde);
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		CardLayout cl = (CardLayout) (panelIzquierdo.getLayout());
		if(e.getSource() == barraMenu.opcionTrenes)
		{
			cl.show(panelIzquierdo, "pTrenes");
		}
		else if(e.getSource() == barraMenu.opcionSe�ales)
		{
			cl.show(panelIzquierdo, "pSe�ales");
		}
		else if(e.getSource() == barraMenu.opcionPagPrincipal)
		{
			cl.show(panelIzquierdo, "pVacio");
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
