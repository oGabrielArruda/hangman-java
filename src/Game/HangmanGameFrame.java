package Game;

import GameMode.HangmanGameMode;

public class HangmanGameFrame extends GameFrame {
    public HangmanGameFrame(HangmanGameMode difficulty) {
        this.add(new HangmanGamePanel(difficulty, this));
        this.title("Hangman");
    }
}
