package GameMode;

public enum GameMode {

    EASY(0),
    MEDIUM(1),
    HARD(2);

    private int difficulty;

    GameMode(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
