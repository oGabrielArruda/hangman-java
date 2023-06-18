import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private JButton btnPlay;
    private JPanel pnlMain;
    private JButton btnWordManager;

    public Main() {
        setContentPane(pnlMain);
        setTitle("Hangman Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameMode().setVisible(true);
                dispose();
            }
        });

        btnWordManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WordManager().setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}
