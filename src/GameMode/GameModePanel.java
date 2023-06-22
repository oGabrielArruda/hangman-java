package GameMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.GameFrame;
import Menu.MenuFrame;

public class GameModePanel extends JPanel {
    private static final int MID_SCREEN_X = 450;
    private static final int MID_SCREEN_Y = 450;
    private static final  int WIDTH_BUTTONS = 150;
    private static final int HEIGHT_BUTTONS = 50;
    private static final int VERTICAL_GAP_BUTTONS = 50;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public GameModePanel(GameModeFrame gameModeFrame) {
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));

        JLabel lblSelectGameMode = new JLabel("Select your game mode:");

        JButton btnEasy = new JButton("Easy");
        JButton btnMedium = new JButton("Medium");
        JButton btnHard = new JButton("Hard");
        JButton btnBackToMenu = new JButton("Back to Menu");

        lblSelectGameMode.setBounds(MID_SCREEN_X - 90, 60, 180, 100);

        btnEasy.setBounds(MID_SCREEN_X - WIDTH_BUTTONS/2, MID_SCREEN_Y - HEIGHT_BUTTONS/2 - 100, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnEasy.setBackground(COLOR_BUTTONS);

        btnMedium.setBounds(MID_SCREEN_X - WIDTH_BUTTONS/2, MID_SCREEN_Y + 2*VERTICAL_GAP_BUTTONS - HEIGHT_BUTTONS/2 - 100, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnMedium.setBackground(COLOR_BUTTONS);

        btnHard.setBounds(MID_SCREEN_X - WIDTH_BUTTONS/2, MID_SCREEN_Y + 4*VERTICAL_GAP_BUTTONS - HEIGHT_BUTTONS/2 - 100, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnHard.setBackground(COLOR_BUTTONS);

        btnBackToMenu.setBounds(MID_SCREEN_X - WIDTH_BUTTONS, MID_SCREEN_Y + 300 - HEIGHT_BUTTONS, 2*WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(new Color(193, 236, 228));

        btnEasy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameFrame(GameMode.EASY);
                gameModeFrame.dispose();
            }
        });

        btnMedium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameFrame(GameMode.MEDIUM);
                gameModeFrame.dispose();
            }
        });

        btnHard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameFrame(GameMode.HARD);
                gameModeFrame.dispose();
            }
        });

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                gameModeFrame.dispose();
            }
        });

        this.add(lblSelectGameMode);

        this.add(btnEasy);
        this.add(btnMedium);
        this.add(btnHard);
        this.add(btnBackToMenu);
    }
}
