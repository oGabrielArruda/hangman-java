package model;

public class Quest {
    private String word;
    private String clue;
    
    public Quest(String word, String clue) {
        this.word = word;
        this.clue = clue;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getClue() {
        return clue;
    }
    public void setClue(String clue) {
        this.clue = clue;
    }
}