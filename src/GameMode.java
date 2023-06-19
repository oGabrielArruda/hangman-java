import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMode extends JFrame {
    private JButton btnClassicMode;
    private JButton btnTwoWordsGameMode;
    private JButton btnMenu;
    private JPanel pnlGameMode;

    public GameMode() {
        setContentPane(pnlGameMode);
        setTitle("Hangman Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        btnClassicMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // I supposed we are going to use the same form for both game modes
                // therefore, I believe we should pass some parameter to differentiate one game mode from another
                new Game().setVisible(true);
                dispose();
            }
        });

        btnTwoWordsGameMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // I supposed we are going to use the same form for both game modes
                // therefore, I believe we should pass some parameter to differentiate one game mode from another
                new Game().setVisible(true);
                dispose();
            }
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });
    }
}
