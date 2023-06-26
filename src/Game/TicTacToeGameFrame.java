package Game;

import Constants.Constants;
import javax.swing.*;

public class TicTacToeGameFrame extends JFrame {
    public TicTacToeGameFrame() {
        this.add(new TicTacToeGamePanel(this));
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
