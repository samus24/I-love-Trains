/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Senal;

/**
 *
 * @author furia
 */
public class SignalListener {

    private static UIsignal uisignal;

    public SignalListener(UIsignal uis) {
        uisignal = uis;
    }

    public void addSignal(Senal signal) {
        uisignal.addSignal(signal);
    }

}