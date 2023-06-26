package Game;

import javax.swing.*;

import Constants.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import GameMode.*;
import Menu.HangmanMenuFrame;
import Menu.MenuFrame;

public class TicTacToeGamePanel extends JPanel {
    private TicTacToeGameFrame gameFrame;
    public TicTacToeGamePanel(TicTacToeGameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);

        JButton btnBackToMenu = new JButton("Back to Menu");

        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 400 - Constants.HEIGHT_BUTTONS, 2 * Constants.WIDTH_BUTTONS, Constants.HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(Constants.COLOR_BACK_BUTTON);

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                gameFrame.dispose();
            }
        });

        this.add(btnBackToMenu);
    }

    private boolean hasLost() {
        return true;
    }

    private boolean hasWon() {
        return true;
    }

    private void checkIfFinished() {
        int option = 3;
        if (hasWon()) {
            option = JOptionPane.showConfirmDialog(null, "Congrats! You have won! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
        }else if (hasLost()) {
            option = JOptionPane.showConfirmDialog(null, "Looks like you have lost! Would you like to play again?", "Too bad :/", JOptionPane.YES_NO_OPTION);
        }
        restart(option);
    }

    private void restart(int option) {
        if (option == 3) return;
        new TicTacToeGameFrame();
        this.gameFrame.dispose();
    }
}
