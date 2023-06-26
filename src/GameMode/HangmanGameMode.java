package GameMode;

/*
 * Enumerate da dificuldade em relação ao tempo da forca
 */

public enum HangmanGameMode {

    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int time;
    
    HangmanGameMode(int difficulty) {
        switch (difficulty) {
            case 0:
                time = 90;
                break;
            case 1:
                time = 60;
                break;
            case 2:
                time = 30;
                break;
        }
    }

    public int getTime() {
        return time;
    }
}
