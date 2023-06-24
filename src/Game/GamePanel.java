package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GameMode.*;
import manager.QuestRandomizer;
import model.Quest;

public class GamePanel extends JPanel {
    private WordPanel pnlWord;
    private final GameMode DIFFICULTY;
    private HangmanState hangmanState;
    private GameFrame gameFrame;
    private int currentTime;
    private Timer timer;
    private static final int MID_SCREEN_X = 450;
    private static final int MID_SCREEN_Y = 450;
    private static final int WIDTH_BUTTONS = 150;
    private static final int HEIGHT_BUTTONS = 50;
    private static final int HORIZONTAL_GAP_BUTTONS = 30;
    private static final int VERTICAL_GAP_BUTTONS = 30;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public GamePanel(GameMode difficulty, GameFrame gameFrame) {
        this.hangmanState = HangmanState.HEAD;
        this.DIFFICULTY = difficulty;
        this.gameFrame = gameFrame;

        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));

        Quest quest = QuestRandomizer.selectRandomQuest();

        pnlWord = new WordPanel(quest.getWord());
        JLabel lblUsedLetters = new JLabel("Used letters: ");
        JLabel lblHintContent = new JLabel(quest.getHint());
        JButton btnBackToGameMode = new JButton("Back to Game Mode Selection");
        
        JLabel lblTimer = new JLabel();

        currentTime = difficulty.getTime();
        this.timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {    
                lblTimer.setText(Integer.toString(currentTime--));
                checkIfFinishedTime();
            }
        });
        timer.start();

        lblTimer.setBounds(0, 90, 900, 50);
        lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
        lblHintContent.setBounds(0, 20, 900, 50);
        lblHintContent.setHorizontalAlignment(SwingConstants.CENTER);
        lblUsedLetters.setBounds(0, 50, 900, 50);
        lblUsedLetters.setHorizontalAlignment(SwingConstants.CENTER);

        pnlWord.setBounds(0, MID_SCREEN_Y + 50, 900, 50);

        btnBackToGameMode.setBounds(MID_SCREEN_X - WIDTH_BUTTONS, MID_SCREEN_Y + 400 - HEIGHT_BUTTONS, 2 * WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToGameMode.setBackground(new Color(193, 236, 228));

        btnBackToGameMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new GameModeFrame();
                gameFrame.dispose();
            }
        });

        loadLetterButtons(lblUsedLetters, pnlWord);

        this.add(lblTimer);
        this.add(lblHintContent);
        this.add(lblUsedLetters);
        this.add(pnlWord);

        this.add(btnBackToGameMode);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon imageIcon = new ImageIcon("utils/assets/images/Enforcado_resized.gif");
        Image image = imageIcon.getImage();
        g.drawImage(image, MID_SCREEN_X, MID_SCREEN_Y, null);
        drawHangman(g);
    }

    private boolean hasLost() {
        return hangmanState == HangmanState.HANGED;
    }

    private boolean hasLostTime() {
        return currentTime == -1;
    }

    private boolean hasWon() {
        return pnlWord.hasGuessedAllLetters() && hangmanState != HangmanState.HANGED && currentTime >= 0;
    }

    private void drawHangman(Graphics g) {
        ImageIcon imageIcon;
        imageIcon = new ImageIcon("utils/assets/images/Enforcado_resized.gif");
        Image image = imageIcon.getImage();
        g.drawImage(image, MID_SCREEN_X, MID_SCREEN_Y, null);
    }

    private void checkIfFinished() {
        int option = 3;
        if (hasWon()) {
            timer.stop();
            option = JOptionPane.showConfirmDialog(null, "Congrats! You have won! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
        }else if (hasLost()) {
            timer.stop();
            option = JOptionPane.showConfirmDialog(null, "Looks like you have lost! Would you like to play again?", "Too bad :/", JOptionPane.YES_NO_OPTION);
        }
        restart(option);
    }

    private void checkIfFinishedTime() {
        int option = 3;
        if (hasLost() || hasWon()){
            timer.stop();
        }
        else if (hasLostTime()) {
            option = JOptionPane.showConfirmDialog(null, "Looks like your time is up! Would you like to play again?", "Too bad :/", JOptionPane.YES_NO_OPTION);
        }
        restart(option);
    }

    private void restart(int option) {
        if (option == 3) return;
        if (option == 0) {
            new GameFrame(DIFFICULTY);
        } else {
            new GameModeFrame();
        }
        this.gameFrame.dispose();
    }

    private void loadLetterButtons(JLabel lblUsedLetters, WordPanel pnlWord) {
        String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

        int line = 0;
        int i = 0;
        for (String letter : letters) {
            JButton newLetterButton = new JButton(letter);

            if (i % 10 == 0) {
                line++;
                i = 0;
            }

            newLetterButton.setBounds(155 + 2 * i * HORIZONTAL_GAP_BUTTONS, 500 + 2 * line * VERTICAL_GAP_BUTTONS, 50,50);
            newLetterButton.setBackground(COLOR_BUTTONS);

            newLetterButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String letter = newLetterButton.getText();
                    boolean matches = pnlWord.matchLetter(letter);

                    if (!matches) {
                        hangmanState = HangmanState.nextBodyPart(hangmanState);
                        lblUsedLetters.setText(lblUsedLetters.getText() + " " + letter);
                    }

                    checkIfFinished();

                    newLetterButton.setVisible(false);
                }
            });

            this.add(newLetterButton);
            i++;
        }
    }
}
