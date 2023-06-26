package model;

/*
 * Classe das Perguntas da Forca
 */

public class Quest {
    private String word;
    private String hint;
    
    // Constructor
    public Quest(String word, String clue) {
        this.word = word;
        this.hint = clue;
    }

    // To String
    public String toString(){
        return word + ';' + hint + '\n';
    }
    
    //Getter e Setters
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