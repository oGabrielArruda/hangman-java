package Game.HangmanGane;

import Game.GameFrame;
import GameMode.HangmanGameMode;

/*
 * Classe do Frame do Jogo da Forca
 */

public class HangmanGameFrame extends GameFrame {
    public HangmanGameFrame(HangmanGameMode difficulty) {
        this.add(new HangmanGamePanel(difficulty, this));
        this.title("Hangman");
    }
}
