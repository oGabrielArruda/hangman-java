package Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import model.History;
import Constants.Constants;
import Popup.PopupFrame;

/*
 * Classe do Gerenciador de Arquivos o Jogo da Velha
 * Implementa a Interface In/Out
 */

public class TicTacToeManager implements IOFiles_Interface <History> {

    // Substitui o histórico atual do arquivo para o histórico h
    public boolean WriteFile (History h){
        try{
            File file = new File(Constants.TICTAC_PATH);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String s = Integer.toString(h.getx()) + "\n" + Integer.toString(h.geto()) + "\n" + Integer.toString(h.getd()) + "\n";
            writer.write(s);
            writer.close();
            return true;
        }
        // Se deu algum erro
        catch(IOException e) {
            new PopupFrame("Error", "Some unexpected error occurred while writing the history of TicTacToe:\n" + e.getMessage());
            return false;
        }
    }

    // Lê o histórico escrito no arquivo
    public ArrayList<History> ReadFile(){
        try{
            File file = new File(Constants.TICTAC_PATH);
            Scanner scan = new Scanner(file);

            int x, o, d;
            x = scan.nextInt();
            o = scan.nextInt();
            d = scan.nextInt();

            scan.close();

            History h = new History(x, o, d);
            ArrayList<History> array = new ArrayList<History>();
            array.add(h);

            return array;
        }
        // Se deu algum erro
        catch(IOException e) {
            new PopupFrame("Error", "Some unexpected error occurred while reading the history of TicTacToe:\n" + e.getMessage());
            return null;
        }
    }

    // retorna o histórico do Jogo
    public String getHistory(){
        ArrayList<History> array = ReadFile();
        History h = array.get(0);
        return h.toString();
    }

    // muda o histórico do Jogo
    public void changeHistory(char c){
        try{
            File file = new File(Constants.TICTAC_PATH);
            Scanner scan = new Scanner(file);

            int x, o, d;
            x = scan.nextInt();
            o = scan.nextInt();
            d = scan.nextInt();

            if(c == 'X'){
                x++;
            }
            else if(c == 'O'){
                o++;
            }
            else if(c == 'D'){
                d++;
            }
            else if(c == 'R'){
                x = 0;
                o = 0;
                d = 0;
            }

            scan.close();

            WriteFile(new History(x, o, d));
        }

        //error message
        catch(IOException e) {
            new PopupFrame("Error", "Some unexpected error occurred in changeHistory:\n" + e.getMessage());
        }
    }
}
