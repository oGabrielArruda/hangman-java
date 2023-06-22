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
    private static final int MID_SCREEN_X = 450;
    private static final int MID_SCREEN_Y = 450;
    private static final int WIDTH_BUTTONS = 150;
    private static final int HEIGHT_BUTTONS = 50;
    private static final int HORIZONTAL_GAP_BUTTONS = 30;
    private static final int VERTICAL_GAP_BUTTONS = 30;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public GamePanel(GameMode difficulty) {
        this.hangmanState = HangmanState.HEAD;
        this.DIFFICULTY = difficulty;

        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));


        Quest quest = QuestRandomizer.selectRandomQuest();

        pnlWord = new WordPanel(quest.getWord());
        JLabel lblUsedLetters = new JLabel("Used letters: ");
        JLabel lblHintContent = new JLabel(quest.getHint());
        JButton btnBackToGameMode = new JButton("Back to Game Mode Selection");

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
            }
        });

        loadLetterButtons(lblUsedLetters, pnlWord);

        this.add(lblHintContent);
        this.add(lblUsedLetters);
        this.add(pnlWord);

        this.add(btnBackToGameMode);
    }

    private boolean hasLost() {
        return hangmanState == HangmanState.HANGED;
    }

    private boolean hasWon() {
        return pnlWord.hasGuessedAllLetters() && hangmanState != HangmanState.HANGED;
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

                    int option = 3;
                    if (hasWon()) {
                        option = JOptionPane.showConfirmDialog(null, "Congrats! You have won! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
                    } else if (hasLost()) {
                        option = JOptionPane.showConfirmDialog(null, "Looks like you have lost! Would you like to play again?", "Too bad :/", JOptionPane.YES_NO_OPTION);
                    }

                    if (option == 0) {
                        new GameFrame(DIFFICULTY);
                    } else if (option == 1 || option == 2) {
                        new GameModeFrame();
                    }

                    newLetterButton.setVisible(false);
                }
            });

            this.add(newLetterButton);
            i++;
        }
    }
}
