package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controlador.Controlador;
import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Senal;

@SuppressWarnings("serial")
public class UIsignal extends JPanel {

    private int nSignals;
    private JTextArea txtX, txtY;
    private Controlador guiControl;
    private Senal anyadir;


    public UIsignal(Controlador controlador) {
    	this.guiControl = controlador;
        nSignals = 0;
        
       
        
        setLayout(new GridLayout(6, 2, 2, 2));

        JPanel panelAdd = new JPanel();
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.X_AXIS));
        JLabel lblX = new JLabel("X:");
        panelAdd.add(lblX);
        txtX = new JTextArea();
        txtX.setPreferredSize(new Dimension(50, 30));
        txtX.setMaximumSize(new Dimension(50, 30));
        panelAdd.add(txtX);
        JLabel lblY = new JLabel("Y:");

        panelAdd.add(lblY);
        txtY = new JTextArea();
        txtY.setPreferredSize(new Dimension(50, 30));
        txtY.setMaximumSize(new Dimension(50, 30));
        panelAdd.add(txtY);
        JButton jb = new JButton("Añadir señal");
        jb.setActionCommand("addSignalButton");
        
        jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coordenada c = new Coordenada(getWhereSignal()[0], getWhereSignal()[1]);
                addSignal();
				guiControl.anadirSenal(c, EstadoSenal.ROJO);
				}
			});
        
        
//        jb.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				addSignal();
//			}
//		});
        
        panelAdd.add(jb);


        add(panelAdd);
        setVisible(true);
    }

    public void addSignal() {
        nSignals++;
        anyadir= new Senal(new Coordenada(Integer.parseInt(txtX.getText()), Integer.parseInt(txtY.getText())), EstadoSenal.ROJO);
        
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        JLabel jlab = new JLabel(nSignals + ")" + anyadir.toString());
        jlab.setAlignmentX(Component.LEFT_ALIGNMENT);
        jp.add(jlab);
        
        JButton jbt = new JButton();
        jbt.setActionCommand("signalButton");
        jbt.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbt.setBackground(Color.red);
        
        //jbt.addActionListener(new ButtonSignalListener(signal,this, this.controlador));
        
        jbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton) e.getSource();
                if (b.getBackground() == Color.RED) {
                    b.setBackground(Color.green);
                } else {
                    b.setBackground(Color.red);
                }
				}
			});
        
        
        jp.add(jbt);

        JButton jbr = new JButton("Eliminar");
        jbr.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jbr.setActionCommand("removSignalButton");
        //jbr.addActionListener(new ButtonSignalListener(signal,this,this.controlador){});
        
        jbr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiControl.eliminarSenal(anyadir);
			}
		});
        
        jp.add(jbr);

        this.add(jp);

        System.out.println(anyadir.toString());
    }

    public int[] getWhereSignal() {
        int[] c = new int[2];
        c[0] = Integer.parseInt(txtX.getText());
        c[1] = Integer.parseInt(txtY.getText());
        return c;
    }
}
