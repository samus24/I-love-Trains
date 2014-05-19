/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Controlador.Controlador;
import Modelo.Coordenada;
import Modelo.EstadoSenal;
import Modelo.Senal;

/**
 *
 * @author furia
 */
public class ButtonSignalListener implements ActionListener {

    private UIsignal uisignal;
    private Controlador guiControl;
    private Senal senal;
    
    public ButtonSignalListener(Senal senal, UIsignal uisignal, Controlador controlador) {
        this.uisignal = uisignal;
        this.guiControl= controlador;
        this.senal = senal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toString()) {
            case "signalButton":
                JButton b = (JButton) e.getSource();
                if (b.getBackground() == Color.RED) {
                    b.setBackground(Color.green);
                } else {
                    b.setBackground(Color.red);
                }
                break;
            case "addSignalButton":
            	Coordenada c = new Coordenada(uisignal.getWhereSignal()[0], uisignal.getWhereSignal()[1]);
                uisignal.addSignal(senal);
                guiControl.anadirSenal(c,EstadoSenal.ROJO);
                break;
                
            case "removSignalButton":
            	guiControl.eliminarSenal(this.senal);
            	break;

            default:


        }

    }
}
