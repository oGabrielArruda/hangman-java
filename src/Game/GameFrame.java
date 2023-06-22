package Game;

import GameMode.GameMode;
import GameMode.GameModePanel;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame(GameMode difficulty) {
        this.add(new GamePanel(difficulty, this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 900);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
