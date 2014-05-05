/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author furia
 */
public class SignalListener {

    private static UIsignal uisignal;

    public SignalListener(UIsignal uis) {
        this.uisignal = uis;
    }

    public void addSignal(Signal signal) {
        uisignal.addSignal(signal);
    }

}