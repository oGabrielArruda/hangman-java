package Game;

import Constants.Constants;
import GameMode.GameMode;
import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(GameMode difficulty) {
        this.add(new GamePanel(difficulty, this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
