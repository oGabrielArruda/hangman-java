package Game;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Constants.Constants;
import Popup.PopupFrame;

public class TicTacToeManager {
    //add a quest to quests.txt
    public static void changeHistory(char c){
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

            String s = Integer.toString(x) + "\n" + Integer.toString(o) + "\n" + Integer.toString(d) + "\n";

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(s);
            writer.close();
            scan.close();
        }

        //error message
        catch(IOException e) {
            new PopupFrame("Error", "Some unexpected error occurred in Quest Add:\n" + e.getMessage());
        }
    }

    //remove a quest from quests.txt
    public static String getHistory(){
        try{
            File file = new File(Constants.TICTAC_PATH);
            Scanner scan = new Scanner(file);

            int x, o, d;
            x = scan.nextInt();
            o = scan.nextInt();
            d = scan.nextInt();

            scan.close();

            return Integer.toString(x) + " / " + Integer.toString(o) + " / " + Integer.toString(d);
        }

        //error message
        catch(IOException e) {
            new PopupFrame("", "Some unexpected error occurred in Quest Removal:\n" + e.getMessage());
            return null;
        }
    }

}
