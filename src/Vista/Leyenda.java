package Vista;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Leyenda extends JPanel {

	private JLabel vagon;
	private JLabel senalRojo;
	private JLabel senalVerde;
	private JLabel locomotora;
	private JLabel via;
	private JLabel ciudad;

	public Leyenda(){
		crearVista();
	}

	private void crearVista() {

		this.setBorder(BorderFactory.createTitledBorder("Leyenda"));
		this.setLayout(new FlowLayout());

		vagon = new JLabel(" Vagón >");
		senalRojo = new JLabel(" Señal roja >");
		senalVerde = new JLabel(" Señal verde >");
		locomotora = new JLabel(" Locomotora >");
		via = new JLabel(" Vía >");
		ciudad = new JLabel(" Ciudad >");

		ImageIcon vagonIcon = new ImageIcon("src/Vista/images/vagon.png");
		JLabel imageVagon = new JLabel(vagonIcon);

		ImageIcon senalRojaIcon = new ImageIcon("src/Vista/images/senalrojo.png");
		JLabel imageSenalRoja = new JLabel(senalRojaIcon);

		ImageIcon senalVerdeIcon = new ImageIcon("src/Vista/images/senalverde.png");
		JLabel imageSenalVerde = new JLabel(senalVerdeIcon);

		ImageIcon locomotoraIcon = new ImageIcon("src/Vista/images/locomotora.png");
		JLabel imageLocomotora = new JLabel(locomotoraIcon);

		ImageIcon viaIcon = new ImageIcon("src/Vista/images/via.png");
		JLabel imageVia = new JLabel(viaIcon);

		ImageIcon ciudadIcon = new ImageIcon("src/Vista/images/ciudad.png");
		JLabel imageCiudad = new JLabel(ciudadIcon);

		this.add(vagon);
		this.add(imageVagon);
		this.add(senalRojo);
		this.add(imageSenalRoja);
		this.add(senalVerde);
		this.add(imageSenalVerde);
		this.add(locomotora);
		this.add(imageLocomotora);
		this.add(via);
		this.add(imageVia);
		this.add(ciudad);
		this.add(imageCiudad);
	}
}
