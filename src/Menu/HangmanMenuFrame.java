package Menu;

import Constants.Constants;
import javax.swing.*;

/*
 * Classe do Frame do Menu da Forca
 */

public class HangmanMenuFrame extends JFrame  {

    public HangmanMenuFrame() {
        this.add(new HangmanMenuPanel(this));
        this.setTitle("Hangman");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
