package QuestManager;

import Menu.MenuPanel;

import javax.swing.*;

public class QuestManagerFrame extends JFrame {

    public QuestManagerFrame() {
        this.add(new QuestManagerPanel(this));
        this.setTitle("Hangman Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(900, 900);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
