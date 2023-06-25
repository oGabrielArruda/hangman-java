package Menu;

import Constants.Constants;
import GameMode.GameModeFrame;
import QuestManager.QuestManagerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    public MenuPanel(MenuFrame menuFrame) {
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);

        JLabel lblWelcome = new JLabel("Welcome to Hangman!", SwingConstants.CENTER);
        lblWelcome.setFont(Constants.FONT(40));

        JButton btnPlay = new JButton("Play");
        btnPlay.setFont(Constants.FONT(20));
        
        JButton btnQuestManager = new JButton("Quest Manager");
        btnQuestManager.setFont(Constants.FONT(20));

        lblWelcome.setBounds(Constants.MID_SCREEN_X - 450, 60, 900, 100);

        btnPlay.setBounds(Constants.MID_SCREEN_X - 150, Constants.MID_SCREEN_Y - 50, 300, 100);
        btnPlay.setBackground(Constants.COLOR_BUTTONS);

        btnQuestManager.setBounds(Constants.MID_SCREEN_X - 150, Constants.MID_SCREEN_Y + 150 - 50, 300, 100);
        btnQuestManager.setBackground(Constants.COLOR_BUTTONS);

        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameModeFrame();
                menuFrame.dispose();
            }
        });

        btnQuestManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new QuestManagerFrame();
                menuFrame.dispose();
            }
        });

        this.add(lblWelcome);
        this.add(btnPlay);
        this.add(btnQuestManager);
    }
}
