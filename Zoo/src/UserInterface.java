import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Swiat swiat;
    Czlowiek czlowiek;

    public UserInterface(Swiat swiat, Czlowiek czlowiek) {

        this.swiat = swiat;
        this.czlowiek = czlowiek;
    }

    public UserInterface(Swiat swiat) {
        this.swiat = swiat;

    }

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(1300, 900));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        DrawingBoard drawingBoard = new DrawingBoard(swiat.getObiekty());
        container.add(drawingBoard, BorderLayout.CENTER);
        JTextArea prawyPanel = new JTextArea("pusto");
        prawyPanel.setPreferredSize(new Dimension(200, 0));
        prawyPanel.setForeground(Color.red);
        prawyPanel.setFocusable(false);
        JTextArea gornyPanel = new JTextArea("Olguś Deptuła s160525");
        gornyPanel.setFocusable(false);
        container.add(gornyPanel, BorderLayout.NORTH);
        container.add(prawyPanel, BorderLayout.EAST);
        container.add(bottonPanel(drawingBoard, prawyPanel, czlowiek), BorderLayout.SOUTH);

    }

    private JPanel bottonPanel(DrawingBoard drawingBoard, JTextArea prawyPanel, Czlowiek czlowiek) {
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton wykonajTure = new JButton("Tura");
        wykonajTure.setPreferredSize(new Dimension(0, 20));
        JTextArea moc = new JTextArea("moc wylaczona");
        KolejnaTuraListener kolejnaTura = new KolejnaTuraListener(swiat, drawingBoard, prawyPanel, czlowiek, moc);
        wykonajTure.addActionListener(kolejnaTura);
        wykonajTure.setFocusable(false);
        moc.setFocusable(false);
        panel.add(wykonajTure);
        JLabel okno = new JLabel("");
        frame.addKeyListener(new KeyboardListener(okno, czlowiek));
        panel.add(okno);
        panel.add(moc);
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
