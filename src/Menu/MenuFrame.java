package Menu;

import Constants.Constants;

import javax.swing.*;

/*
 * Classe do Frame do Menu Principal
 */

public class MenuFrame extends JFrame  {

    public MenuFrame() {
        this.add(new MenuPanel(this));
        this.setTitle("Menu");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
