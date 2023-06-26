package Game;

import Constants.Constants;
import javax.swing.*;

public abstract class GameFrame extends JFrame {
    public void title(String title) {
        this.setTitle(title);
    }
    public GameFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
