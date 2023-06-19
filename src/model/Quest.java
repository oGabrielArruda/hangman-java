package model;

public class Quest {
    private String word;
    private String hint;
    
    public Quest(String word, String clue) {
        this.word = word;
        this.hint = clue;
    }

    public String getWord() {
        return word;
    }
    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }
    public void setClue(String clue) {
        this.hint = clue;
    }
}