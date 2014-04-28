package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicOptionPaneUI;

public class UIsignal extends JPanel {

    private int nSignals;
    private JTextArea txtX, txtY;

    public UIsignal()
    {
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
        jb.addActionListener(new ButtonSignalListener(this));
        panelAdd.add(jb);


        add(panelAdd);
        setVisible(true);
        addSignal(new Signal(2, 2));
        addSignal(new Signal(3, 5));
    }

    public void addSignal(Signal signal) {
        nSignals++;
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.X_AXIS));
        JLabel jlab = new JLabel(nSignals + ")" + signal.toString());
        jlab.setAlignmentX(Component.LEFT_ALIGNMENT);
        jp.add(jlab);
        JButton jbt = new JButton();
        jbt.setActionCommand("signalButton");
        jbt.setAlignmentX(Component.CENTER_ALIGNMENT);
        jbt.setBackground(Color.red);
        jbt.addActionListener(new ButtonSignalListener(this));
        jp.add(jbt);

        JButton jbr = new JButton("Eliminar");
        jbr.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jbr.setActionCommand("removSignalButton");
        jbr.addActionListener(new ButtonSignalListener(this));
        jp.add(jbr);

        this.add(jp);

        System.out.println(signal.toString());
    }

    public int[] getWhereSignal() {
        int[] c = new int[2];
        c[0] = Integer.parseInt(txtX.getText());
        c[1] = Integer.parseInt(txtY.getText());
        return c;
    }
}
