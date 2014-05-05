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

/**
 *
 * @author furia
 */
public class ButtonSignalListener implements ActionListener {

    UIsignal uisignal;
    Controlador guiControl;

    public ButtonSignalListener(UIsignal uisignal, Controlador controlador) {
        this.uisignal = uisignal;
        this.guiControl= controlador;
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
                uisignal.addSignal(new Signal(uisignal.getWhereSignal()[0], uisignal.getWhereSignal()[1]));
                guiControl.anadirSenal(null, null);
                break;

            default:


        }

    }
}
