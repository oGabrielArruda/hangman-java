package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import GameMode.GameMode;
import Menu.MenuFrame;

public class GamePanel extends JPanel {

    private static final int MID_SCREEN_X = 450;
    private static final int MID_SCREEN_Y = 450;
    private static final int WIDTH_BUTTONS = 150;
    private static final int HEIGHT_BUTTONS = 50;
    private static final int HORIZONTAL_GAP_BUTTONS = 30;
    private static final int VERTICAL_GAP_BUTTONS = 30;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    private ArrayList<String> wordList;
    private ArrayList<String> hintList;

    private void loadWordsAndHints() {
        wordList = new ArrayList<>();
        hintList = new ArrayList<>();
        try {
            File file = new File("files//quests.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                String word = "", hint = "";
                boolean foundSeparator = false;
                for (int i = 0; i < data.length(); ++i) {
                    if (data.charAt(i) == ';') {
                        foundSeparator = true;
                    } else if (!foundSeparator) {
                        word += data.charAt(i);
                    } else {
                        hint += data.charAt(i);
                    }
                }
                wordList.add(word);
                hintList.add(hint);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo de dicas.");
        }
    }

    public int getRandomIndex(int min, int max) {
        /* Retorna um inteiro pseudoaleatório no intervalo [min, max) */
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public GamePanel(GameMode difficulty) {
        String[] letters = new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));

        this.loadWordsAndHints();

        int chosenIndex = this.getRandomIndex(0, wordList.size());
        String wordContent = this.wordList.get(chosenIndex);
        String hintContent = this.hintList.get(chosenIndex);

        JLabel lblHint = new JLabel("Here goes the hint:");
        JLabel lblHintContent = new JLabel(hintContent);
        JButton btnBackToMenu = new JButton("Back to Menu");

        lblHint.setBounds(MID_SCREEN_X - 70, 30, 180, 100);
        lblHintContent.setBounds(MID_SCREEN_X - 70, 30, 180, 300);

        btnBackToMenu.setBounds(MID_SCREEN_X - WIDTH_BUTTONS, MID_SCREEN_Y + 400 - HEIGHT_BUTTONS, 2 * WIDTH_BUTTONS,
                HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(new Color(193, 236, 228));

        int line = 0;
        int i = 0;
        for (String letter : letters) {
            JButton newLetterButton = new JButton(letter);

            if (i % 10 == 0) {
                line++;
                i = 0;
            }

            newLetterButton.setBounds(155 + 2 * i * HORIZONTAL_GAP_BUTTONS, 500 + 2 * line * VERTICAL_GAP_BUTTONS, 50,
                    50);
            newLetterButton.setBackground(COLOR_BUTTONS);

            this.add(newLetterButton);
            i++;
        }

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
            }
        });

        this.add(lblHint);
        this.add(lblHintContent);

        this.add(btnBackToMenu);
    }
}
