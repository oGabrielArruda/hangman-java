package GameMode;

import Constants.Constants;
import javax.swing.*;

public class HangmanGameModeFrame extends JFrame {
    public HangmanGameModeFrame() {
        this.add(new HangmanGameModePanel(this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
