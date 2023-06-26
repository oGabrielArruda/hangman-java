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

        // criamos os espaços para as letras da palavra
        for(int i = 0; i < this.WORD.length(); i++) {
            JLabel lblLetter = new JLabel("_", SwingConstants.CENTER);
            lblLetter.setFont(Constants.FONT(30));

            labels.add(lblLetter);
            this.add(lblLetter);
        }
    }

    // método de verificação para sabermos quais letras foram acertadas
    public boolean matchLetter(String letter) {
        // primeiro, vemos quais são as posições da letra na palavra
        ArrayList<Integer> letterPosition = getPositionsOfLetter(this.WORD, letter);
        // se houver ocorrências daquela letra na palavra
        if(letterPosition.size() > 0) {
            // trocamos os espaços pela letra desejada
            for(int position : letterPosition) {
                JLabel lblLetter = labels.get(position);
                lblLetter.setText(letter);
            }

            return true;
        }

        return false;
    }

    // método utilizado para sabermos se todas as letras foram acertadas
    public boolean hasGuessedAllLetters() {
        for(JLabel label : labels) {
            if(label.getText().equals("_")) {
                return false;
            }
        }

        return true;
    }

    // método utilizado para sabermos quais são todas as posições de uma determinada letra
    private ArrayList<Integer> getPositionsOfLetter(String word, String letter) {
        ArrayList<Integer> letterPosition = new ArrayList<Integer>();
        String lowerCaseWord = word.toLowerCase();

        // percorremos toda a palavra e comparamos seus caracteres com a letra desejada
        for(int i = 0; i < word.length(); i++) {
            if(lowerCaseWord.charAt(i) == letter.toLowerCase().charAt(0)) {
                letterPosition.add(i);
            }
        }

        return letterPosition;
    }
}
