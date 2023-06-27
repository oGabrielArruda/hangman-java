package Game.TicTacToeGame;

import Game.GameFrame;

/*
 * Classe do Frame do Jogo da Velha
 */

public class TicTacToeGameFrame extends GameFrame {
    public TicTacToeGameFrame() {
        this.add(new TicTacToeGamePanel(this));
        this.title("TicTacToe");
    }
}
