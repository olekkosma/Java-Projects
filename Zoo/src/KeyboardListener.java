import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class KeyboardListener implements KeyListener {

    JLabel okno;
    Czlowiek czlowiek;

    public KeyboardListener(JLabel okno, Czlowiek czlowiek) {
        this.okno = okno;
        this.czlowiek = czlowiek;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            okno.setText("lewo");
            czlowiek.setPlanowanePolozenie(new Polozenie(czlowiek.getPolozenieX() - 1, czlowiek.getPolozenieY()));
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            okno.setText("prawo");
            czlowiek.setPlanowanePolozenie(new Polozenie(czlowiek.getPolozenieX() + 1, czlowiek.getPolozenieY()));
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            okno.setText("gora");
            czlowiek.setPlanowanePolozenie(new Polozenie(czlowiek.getPolozenieX(), czlowiek.getPolozenieY() - 1));
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            okno.setText("dol");
            czlowiek.setPlanowanePolozenie(new Polozenie(czlowiek.getPolozenieX(), czlowiek.getPolozenieY() + 1));
        }
        if (e.getKeyCode() == KeyEvent.VK_M) {

            if (czlowiek.getMocSpecjalna() == -5) {
                czlowiek.setMocSpecjalna(5);
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
