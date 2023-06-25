package QuestManager;

import Constants.Constants;
import javax.swing.*;

public class QuestManagerFrame extends JFrame {

    public QuestManagerFrame() {
        this.add(new QuestManagerPanel(this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.MID_SCREEN_X, Constants.MID_SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
