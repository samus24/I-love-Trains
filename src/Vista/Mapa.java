package vista;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import modelo.Mundo;

/**
 * Construye un JPanel con un JTextArea para representar la información del mundo en un mapa de caracteres.
 * @author Miguel Angel Caballero
 */
public class Mapa extends JPanel
{
	private Mundo mundo;
	private JTextArea salida;

	public Mapa()
	{
		mundo = new Mundo();
		iniciarVista();
	}
	
	private void iniciarVista()
	{
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Mapa"));

		salida = mundo.mostrarMapa();
		salida.setFont(new Font("Courier", Font.PLAIN, 16));
		salida.setEditable(false);
		
		this.add(salida);
	}
}
