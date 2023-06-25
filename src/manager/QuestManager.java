package manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Constants.Constants;
import Popup.PopupFrame;

public class QuestManager {
    //add a quest to quests.txt
    public static void addWord(String word, String hint){
        try{
            File file = new File(Constants.QUESTS_PATH);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            
            //remove invalid characters
            word = word.replaceAll("[^A-Za-z\\s]", "");
            word = word.trim();
            word = word.replaceAll("\\s+", " ");

            hint = hint.replaceAll("[^A-Za-z\\s]", "");
            hint = hint.trim();
            hint = hint.replaceAll("\\s+", " ");

            //catch errors
            if(word.equals("")){
                new PopupFrame("Error", "Write a word.");
            }
            else if(hint.equals("")){
                new PopupFrame("Error", "Write a hint.");
            }
            else if(findString(word) != -1){
                new PopupFrame("Error", "Word already added.");
            }

            //add the quest
            else{
                writer.write(word + ";" + hint + "\n");
                new PopupFrame("", "Quest has been added.");
            }

            writer.close();
        }

        //error message
        catch(Exception e) {
            new PopupFrame("Error", "Some unexpected error occurred in Quest Add:\n" + e.getMessage());
        }
    }

    //remove a quest from quests.txt
    public static void removeWord(String word){
        try{
            File file = new File(Constants.QUESTS_PATH);
            
            //remove invalid characters
            word = word.replaceAll("[^A-Za-z\\s]", "");
            word = word.trim();
            word = word.replaceAll("\\s+", " ");
            
            //find the word
            int line = findString(word);
            
            //catch errors
            if(word.equals("")){
                new PopupFrame("Error", "Write a word.");
            }
            else if(line == -1){
                new PopupFrame("Error", "Word not found.");
            }

            //remove the quest
            else{
                Scanner scan = new Scanner(file);
                String s = "";
                
                for(int i = 0; i < line; i ++){
                    s += scan.nextLine() + "\n";
                }
                scan.nextLine();
                while(scan.hasNextLine()){
                    s += scan.nextLine() + "\n";
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(s);
                writer.close();

                new PopupFrame("", "Quest has been removed.");
                scan.close();
            }
        }

        //error message
        catch(Exception e) {
            new PopupFrame("", "Some unexpected error occurred in Quest Removal:\n" + e.getMessage());
        }
    }

    //find the line with a given word in quests.txt
    public static int findString(String s){
        try{
            File file = new File(Constants.QUESTS_PATH);   
            int linha = -1;
            boolean ok = false;
            Scanner scan = new Scanner(file);
            
            //find the word
            while(scan.hasNextLine()){
                String txt = scan.nextLine(); linha ++;
                int i = 0;
                String w = "";
                while(txt.charAt(i) != ';'){
                    w += txt.charAt(i);
                    i++;
                }
                if(w.equals(s)){
                    ok = true;
                    break;
                }
            }
            scan.close();

            //test if found
            if (ok) return linha;
            else return -1;
        }

        //error message
        catch (IOException e){
            new PopupFrame("", "Some unexpected error occurred in Reading File:\n" + e.getMessage());
            return -1;
        }
    }
}
