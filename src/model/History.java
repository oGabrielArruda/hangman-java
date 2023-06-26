package model;

public class History {
    private int x;
    private int o;
    private int d;
    
    public History(int x, int o, int d) {
        this.x = x;
        this.o = o;
        this.d = d;
    }

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

    public String toString(){
        return Integer.toString(x) + " / " + Integer.toString(o) + " / " + Integer.toString(d);
    }
}
