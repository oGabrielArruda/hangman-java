package Menu;

import javax.swing.*;

public class MenuFrame extends JFrame  {

        public MenuFrame() {
                this.add(new MenuPanel(this));
                this.setTitle("Hangman Game");
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setSize(900, 900);
                this.setResizable(false);
                this.setVisible(true);
                this.setLocationRelativeTo(null);
        }
}
