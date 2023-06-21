package Menu;

import GameMode.GameModeFrame;
import QuestManager.QuestManagerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    private static int MID_SCREEN_X = 450;
    private static int MID_SCREEN_Y = 450;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public MenuPanel() {
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));
        JLabel lblWelcome = new JLabel("Welcome to Hangman!");
        JButton btnPlay = new JButton("Play");
        JButton btnQuestManager = new JButton("Quest Manager");

        lblWelcome.setBounds(MID_SCREEN_X - 80, 60, 300, 100);

        btnPlay.setBounds(MID_SCREEN_X - 100, MID_SCREEN_Y - 25, 200, 50);
        btnPlay.setBackground(COLOR_BUTTONS);

        btnQuestManager.setBounds(MID_SCREEN_X - 100, MID_SCREEN_Y + 100 - 25, 200, 50);
        btnQuestManager.setBackground(COLOR_BUTTONS);

        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameModeFrame();
            }
        });

        btnQuestManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new QuestManagerFrame();
            }
        });

        this.add(lblWelcome);
        this.add(btnPlay);
        this.add(btnQuestManager);
    }
}
