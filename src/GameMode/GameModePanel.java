package GameMode;

import Constants.Constants;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Game.GameFrame;
import Menu.MenuFrame;

public class GameModePanel extends JPanel {
    private static final int WIDTH_BUTTONS = Constants.WIDTH_BUTTONS * 3/2;
    private static final int HEIGHT_BUTTONS = Constants.HEIGHT_BUTTONS * 3/2;
    private static final int VERTICAL_GAP_BUTTONS = Constants.VERTICAL_GAP_BUTTONS * 3/2;

    public GameModePanel(GameModeFrame gameModeFrame) {
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);

        JLabel lblSelectGameMode = new JLabel("Select your game mode:", SwingConstants.CENTER);
        lblSelectGameMode.setFont(Constants.FONT(40));

        JButton btnEasy = new JButton("Easy");
        JButton btnMedium = new JButton("Medium");
        JButton btnHard = new JButton("Hard");
        JButton btnBackToMenu = new JButton("Back to Menu");

        // posicionamos todos os componentes da forma correta
        lblSelectGameMode.setBounds(Constants.MID_SCREEN_X - 450, 60, Constants.SCREEN_X, Constants.HEIGHT_BUTTONS * 2);

        btnEasy.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2, Constants.MID_SCREEN_Y - HEIGHT_BUTTONS/2 - 130, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnEasy.setBackground(Constants.COLOR_BUTTONS);
        btnEasy.setFont(Constants.FONT(30));

        btnMedium.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2, Constants.MID_SCREEN_Y + 2*VERTICAL_GAP_BUTTONS - HEIGHT_BUTTONS/2 - 130, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnMedium.setBackground(Constants.COLOR_BUTTONS);
        btnMedium.setFont(Constants.FONT(30));

        btnHard.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2, Constants.MID_SCREEN_Y + 4*VERTICAL_GAP_BUTTONS - HEIGHT_BUTTONS/2 - 130, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnHard.setBackground(Constants.COLOR_BUTTONS);
        btnHard.setFont(Constants.FONT(30));

        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 300 - HEIGHT_BUTTONS - 30, 2*WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(new Color(193, 236, 228));
        btnBackToMenu.setFont(Constants.FONT(30));

        // para cada botão, redirecionamos o jogador para a tela do jogo com a dificuldade desejada
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
