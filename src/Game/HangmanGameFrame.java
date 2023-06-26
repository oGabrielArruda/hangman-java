package Game;

import Constants.Constants;
import GameMode.HangmanGameMode;
import javax.swing.*;

public class HangmanGameFrame extends JFrame {
    public HangmanGameFrame(HangmanGameMode difficulty) {
        this.add(new HangmanGamePanel(difficulty, this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
