package GameMode;

public enum HangmanGameMode {

    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int difficulty;
    private int time;
    
    HangmanGameMode(int difficulty) {
        this.difficulty = difficulty;
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
