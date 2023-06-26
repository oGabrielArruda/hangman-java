package Game;

import javax.swing.*;

import Constants.Constants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Menu.MenuFrame;

public class TicTacToeGamePanel extends GamePanel {
    private TicTacToeGameFrame gameFrame;
    private boolean turn; // true: X, false: O

    public TicTacToeGamePanel(TicTacToeGameFrame gameFrame) {
        this.gameFrame = gameFrame;
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);
        
        turn = true;

        for (int i = 0; i < 9; ++i) {
            JButton newBtn = new JButton();
            newBtn.setBounds(230 + 2*(i%3) * (Constants.HORIZONTAL_GAP_BUTTONS + 50), 200 + 2 * (i/3) * (Constants.VERTICAL_GAP_BUTTONS + 50), 130,130);
            newBtn.setBackground(Constants.COLOR_BUTTONS);
            newBtn.setFont(Constants.FONT(40));

            newBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (newBtn.getText().length() == 0) { // Ainda não foi usado
                        if (turn) {
                            newBtn.setText("X");
                        } else {
                            newBtn.setText("O");
                        }
                        turn = !turn;
                    }
                }
            });
            this.add(newBtn);
        }
        
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

    public boolean hasLost() {
        return true;
    }

    public boolean hasWon() {
        return true;
    }

    public void checkIfFinished() {
        int option = 3;
        if (hasWon()) {
            option = JOptionPane.showConfirmDialog(null, "Congrats! You have won! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
        }else if (hasLost()) {
            option = JOptionPane.showConfirmDialog(null, "Looks like you have lost! Would you like to play again?", "Too bad :/", JOptionPane.YES_NO_OPTION);
        }
        restart(option);
    }

    public void restart(int option) {
        if (option == 3) return;
        new TicTacToeGameFrame();
        this.gameFrame.dispose();
    }
}
