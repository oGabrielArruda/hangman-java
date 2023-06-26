package Menu;

import Constants.Constants;
import GameMode.HangmanGameModeFrame;
import QuestManager.QuestManagerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanMenuPanel extends JPanel {
    //Constructor
    public HangmanMenuPanel(HangmanMenuFrame menuFrame) {
        //VISUAL

        //no layout
        this.setLayout(null);

        //set background color
        this.setBackground(Constants.COLOR_BACKGROUND);

        //title text
        JLabel lblWelcome = new JLabel("Welcome to Hangman!", SwingConstants.CENTER);
        lblWelcome.setFont(Constants.FONT(40));
        lblWelcome.setBounds(0, Constants.HEIGHT_BUTTONS * 2 - Constants.MID_SCREEN_Y, Constants.SCREEN_X, Constants.SCREEN_Y);

        //play button
        JButton btnPlay = new JButton("Play");
        btnPlay.setFont(Constants.FONT(20));
        btnPlay.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y, Constants.WIDTH_BUTTONS * 2, Constants.HEIGHT_BUTTONS * 2);
        btnPlay.setBackground(Constants.COLOR_BUTTONS);
        
        //quest manager button
        JButton btnQuestManager = new JButton("Quest Manager");
        btnQuestManager.setFont(Constants.FONT(20));
        btnQuestManager.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + Constants.HEIGHT_BUTTONS * 2 + Constants.VERTICAL_GAP_BUTTONS, Constants.WIDTH_BUTTONS * 2, Constants.HEIGHT_BUTTONS * 2);
        btnQuestManager.setBackground(Constants.COLOR_BUTTONS);

        // Back to menu button
        JButton btnBackToMenu = new JButton("Back to Menu");
        btnBackToMenu.setFont(Constants.FONT(20));
        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 400 - Constants.HEIGHT_BUTTONS, 2 * Constants.WIDTH_BUTTONS, Constants.HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(Constants.COLOR_BACK_BUTTON);

        //FUNCTIONS

        //open play menu
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HangmanGameModeFrame();
                menuFrame.dispose();
            }
        });

        //open quest manager menu
        btnQuestManager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new QuestManagerFrame();
                menuFrame.dispose();
            }
        });

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                menuFrame.dispose();
            }
        });

        //add label
        this.add(lblWelcome);

        //add buttons
        this.add(btnPlay);
        this.add(btnQuestManager);
        this.add(btnBackToMenu);
    }
}
