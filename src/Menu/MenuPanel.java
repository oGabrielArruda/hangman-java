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

    public MenuPanel(MenuFrame menuFrame) {
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));
        JLabel lblWelcome = new JLabel("Welcome to Hangman!", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
        JButton btnPlay = new JButton("Play");
        JButton btnQuestManager = new JButton("Quest Manager");

        lblWelcome.setBounds(MID_SCREEN_X - 450, 60, 900, 100);

        btnPlay.setBounds(MID_SCREEN_X - 100, MID_SCREEN_Y - 25, 200, 50);
        btnPlay.setBackground(COLOR_BUTTONS);

        btnQuestManager.setBounds(MID_SCREEN_X - 100, MID_SCREEN_Y + 100 - 25, 200, 50);
        btnQuestManager.setBackground(COLOR_BUTTONS);

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
