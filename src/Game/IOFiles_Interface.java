package Game;

import java.util.ArrayList;

public interface IOFiles_Interface <T> {
    //grava arquivos 
    public boolean WriteFile (T t);

    //lê dos arquivos
    public ArrayList<T> ReadFile();
}
