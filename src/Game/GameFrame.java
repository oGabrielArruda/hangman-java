package Game;

import Constants.Constants;
import javax.swing.*;

/*
 * Classe abstrata do frame dos jogos
 */

public abstract class GameFrame extends JFrame {
    public void title(String title) {
        /*
         * Método para definir o título da tela
         */
        this.setTitle(title);
    }
    public GameFrame() {
        /*
         * Define detalhes visuais
         */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(Constants.SCREEN_X, Constants.SCREEN_Y);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
