package Game;

import javax.swing.JPanel;

/*
 * Classe abstrata do painel dos jogos
 */

public abstract class GamePanel extends JPanel {
    public abstract void checkIfFinished();
    public abstract void restart(int option);
}
