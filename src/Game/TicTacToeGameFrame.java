package Game;

public class TicTacToeGameFrame extends GameFrame {
    public TicTacToeGameFrame() {
        this.add(new TicTacToeGamePanel(this));
        this.title("TicTacToe");
    }
}
