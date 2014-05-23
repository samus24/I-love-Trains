package Vista;

import java.awt.BorderLayout;

import javax.swing.SwingUtilities;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controlador.Controlador;
import Modelo.EstadoSenal;
import Modelo.Senal;

@SuppressWarnings("serial")
public class Principal extends JFrame implements ItemListener{
	private static Mapa mapa;
	private GuiTrenes trains;
	private GuiSignal senales;
	private static Controlador controlador;
	private String [] vectorCadena = {"Principal","Trenes","Señales"};
	private Leyenda leyenda;
	private boolean fin=false;

	private JPanel cards;

	@SuppressWarnings("static-access")
	public Principal (Controlador controlador) {
		this.controlador = controlador;	
		trains = new GuiTrenes(this.controlador);
		senales = new GuiSignal(this.controlador);
		mapa = new Mapa(this.controlador);
		leyenda = new Leyenda();
		crearPanelPrincipal();
		trains.setVisible(true);
	}

	public void crearPanelPrincipal() {
		Container contentPane = getContentPane();

		final JPanel cp = new JPanel();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JComboBox c = new JComboBox(vectorCadena);
		c.setEditable(false);
		c.addItemListener(this);
		cp.add(c,FlowLayout.LEFT);
		contentPane.add(cp,BorderLayout.NORTH);
		
		JPanel p1 = new JPanel(new FlowLayout());

		JButton start = new JButton();
		start.setIcon(createImageIcon("images/start.png"));
		start.setToolTipText("Start");

		final JButton quit = new JButton();
		quit.setIcon(createImageIcon("images/salir.png"));
		quit.setToolTipText("Quit");

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				new Thread (new Runnable() {
					@SuppressWarnings("static-access")
					@Override
					public void run() {
						modeStart();
						int cont=0;
						EstadoSenal c;
						while(!controlador.start() || fin){
							cont++;
							if(cont==8){
								cont=0;
								ArrayList<Senal> s = controlador.getSenales();
								for(int j = 0; j< s.size(); j++){
									s.get(j).setEstado();
									c = s.get(j).getEstado();
									if(c == c.ROJO)
										controlador.getEstadoMundo()[s.get(j).getCoordenada().getCoordenadaX()][s.get(j).getCoordenada().getCoordenadaY()]= 'r';
									else
										controlador.getEstadoMundo()[s.get(j).getCoordenada().getCoordenadaX()][s.get(j).getCoordenada().getCoordenadaY()]= 'v';
								}
							}
							if(quit.isSelected()){
								fin=true;									
							}
							actualizarMapa();
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
							}
						}
						JOptionPane.showMessageDialog(null, new JLabel("Fin de la Simulación"));
						System.exit(0);
					}

				}).start();
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		cards = new JPanel();
		cards.setLayout(new CardLayout());

		p1.add(start,BorderLayout.PAGE_START); 
		p1.add(quit,BorderLayout.PAGE_END);

		JPanel p2 = new JPanel();
		p2.add(trains);

		JPanel p3 = new JPanel();
		p3.add(senales);

		cards.add("Principal", p1);
		cards.add("Trenes", p2);
		cards.add("Señales", p3);

		contentPane.add(cards, BorderLayout.LINE_START);
		contentPane.add(leyenda, BorderLayout.SOUTH);
		contentPane.add(mapa, BorderLayout.CENTER);

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);        
	}

	protected JFrame modeStart() {
		JFrame modeStart = new JFrame();
		Container contenido=modeStart.getContentPane();

		JButton hola = new JButton("HHHHHH");
		contenido.add(mapa);
		add(hola);

		modeStart.setExtendedState(JFrame.MAXIMIZED_BOTH);
		modeStart.pack();
		modeStart.setDefaultCloseOperation(EXIT_ON_CLOSE);
		modeStart.setVisible(true); 

		return modeStart;
	}

	public void itemStateChanged(final ItemEvent evt) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				CardLayout cl = (CardLayout)(cards.getLayout());
				cl.show(cards, (String)evt.getItem());
			}
		});

	}

	private static ImageIcon createImageIcon(String image){
		java.net.URL imgURL = Principal.class.getResource(image);
		if (imgURL != null) return new ImageIcon(imgURL);
		return null;
	}
	public static void actualizarMapa(){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				mapa.updateView();	
			}
		});

	}

}