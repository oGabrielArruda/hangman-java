package Menu;

import Constants.Constants;
import Game.TicTacToeGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
    //Constructor
    public MenuPanel(MenuFrame menuFrame) {
        //VISUAL

        //no layout
        this.setLayout(null);

        //set background color
        this.setBackground(Constants.COLOR_BACKGROUND);

        //title text
        JLabel lblWelcome = new JLabel("Welcome! Choose your game:", SwingConstants.CENTER);
        lblWelcome.setFont(Constants.FONT(40));
        lblWelcome.setBounds(0, Constants.HEIGHT_BUTTONS * 2 - Constants.MID_SCREEN_Y, Constants.SCREEN_X, Constants.SCREEN_Y);

        //play button
        JButton btnHangman = new JButton("Hangman");
        btnHangman.setFont(Constants.FONT(20));
        btnHangman.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y, Constants.WIDTH_BUTTONS * 2, Constants.HEIGHT_BUTTONS * 2);
        btnHangman.setBackground(Constants.COLOR_BUTTONS);
        
        //quest manager button
        JButton btnTicTacToe = new JButton("TicTacToe");
        btnTicTacToe.setFont(Constants.FONT(20));
        btnTicTacToe.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + Constants.HEIGHT_BUTTONS * 2 + Constants.VERTICAL_GAP_BUTTONS, Constants.WIDTH_BUTTONS * 2, Constants.HEIGHT_BUTTONS * 2);
        btnTicTacToe.setBackground(Constants.COLOR_BUTTONS);

        //FUNCTIONS

        //open play menu
        btnHangman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HangmanMenuFrame();
                menuFrame.dispose();
            }
        });

        //open quest manager menu
        btnTicTacToe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TicTacToeGameFrame();
                menuFrame.dispose();
            }
        });

        //add label
        this.add(lblWelcome);

        //add buttons
        this.add(btnHangman);
        this.add(btnTicTacToe);
    }
}
