package Game;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WordPanel extends JPanel {

    private final String WORD;
    private ArrayList<JLabel> labels;

    public WordPanel(String word) {
        this.WORD = word;
        labels = new ArrayList<JLabel>();

        this.setLayout(new FlowLayout());
        this.setBackground(Constants.COLOR_BACKGROUND);

        for(int i = 0; i < this.WORD.length(); i++) {
            JLabel lblLetter = new JLabel("_", SwingConstants.CENTER);
            lblLetter.setFont(Constants.FONT(30));

            labels.add(lblLetter);
            this.add(lblLetter);
        }
    }

    public boolean matchLetter(String letter) {
        ArrayList<Integer> letterPosition = getPositionsOfLetter(this.WORD, letter);
        if(letterPosition.size() > 0) {
            for(int position : letterPosition) {
                JLabel lblLetter = labels.get(position);
                lblLetter.setText(letter);
            }

            return true;
        }

        return false;
    }

    public boolean hasGuessedAllLetters() {
        for(JLabel label : labels) {
            if(label.getText().equals("_")) {
                return false;
            }
        }

        return true;
    }

    private ArrayList<Integer> getPositionsOfLetter(String word, String letter) {
        ArrayList<Integer> letterPosition = new ArrayList<Integer>();
        String lowerCaseWord = word.toLowerCase();

        for(int i = 0; i < word.length(); i++) {
            if(lowerCaseWord.charAt(i) == letter.toLowerCase().charAt(0)) {
                letterPosition.add(i);
            }
        }

        return letterPosition;
    }
}
