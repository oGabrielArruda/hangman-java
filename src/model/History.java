package model;

/*
 * Classe do Histórico do Jogo da Velha
 */

public class History {
    //X wins, O wins, Draws
    private int x;
    private int o;
    private int d;
    
    // Constructor
    public History(int x, int o, int d) {
        this.x = x;
        this.o = o;
        this.d = d;
    }

    // To String
    public String toString(){
        return Integer.toString(x) + " / " + Integer.toString(o) + " / " + Integer.toString(d);
    }

    // Getters e Setters
    public int getx() {
        return x;
    }
    public void setx(int x) {
        this.x = x;
    }

    public int geto() {
        return o;
    }
    public void seto(int o) {
        this.o = o;
    }

    public int getd() {
        return d;
    }
    public void setd(int d) {
        this.d = d;
    }
}
