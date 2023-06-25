package Menu;

import Constants.Constants;
import javax.swing.*;

public class MenuFrame extends JFrame  {

        public MenuFrame() {
                this.add(new MenuPanel(this));
                this.setTitle("Hangman Game");
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
                this.setResizable(false);
                this.setVisible(true);
                this.setLocationRelativeTo(null);
        }
}
