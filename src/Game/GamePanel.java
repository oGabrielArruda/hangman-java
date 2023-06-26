package Game;

import javax.swing.JPanel;

public abstract class GamePanel extends JPanel {
    public abstract void checkIfFinished();
    public abstract void restart(int option);
}
