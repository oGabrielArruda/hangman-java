package GameMode;

import javax.swing.*;

public class GameModeFrame extends JFrame {
    public GameModeFrame() {
        this.add(new GameModePanel());
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 900);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
