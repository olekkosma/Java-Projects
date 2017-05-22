
package java_olga_projekt;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class KolejnaTuraListener implements ActionListener {

    Swiat swiat;
    Component component;
    JTextArea prawyPanel;
    Czlowiek czlowiek;
    JTextArea moc;

    public KolejnaTuraListener(Swiat swiat, Component component, JTextArea prawyPanel, Czlowiek czlowiek, JTextArea moc) {
        this.swiat = swiat;
        this.component = component;
        this.prawyPanel = prawyPanel;
        this.czlowiek = czlowiek;
        this.moc = moc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        swiat.wykonajTure();
        prawyPanel.setText(swiat.getRelacja());
        if (czlowiek.getMocSpecjalna() > 0) {
            moc.setText("moc specjalna wlaczona:" + czlowiek.getMocSpecjalna());
        }
        if (czlowiek.getMocSpecjalna() < 1) {
            moc.setText("moc specjalna wylaczona");
        }
        component.repaint();

    }

}
