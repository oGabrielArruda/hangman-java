package GameMode;

import Constants.Constants;
import javax.swing.*;

public class GameModeFrame extends JFrame {
    public GameModeFrame() {
        this.add(new GameModePanel(this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
