package QuestManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Constants.Constants;
import Menu.MenuFrame;
import Popup.PopupFrame;

public class QuestManagerPanel extends JPanel {
    private static final int GAP_BUTTONS = 100;
    private static final int WIDTH_BUTTONS = 200;
    private static final int HEIGHT_BUTTONS = 50;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public QuestManagerPanel(QuestManagerFrame questManagerFrame) {
        this.setLayout(null);
        
        this.setBackground(new Color(255, 208, 208));
        
        JLabel lblQuestManager = new JLabel("Quest Manager", SwingConstants.CENTER);
        lblQuestManager.setFont(Constants.FONT(40));

        JLabel lblWord = new JLabel("Word");
        lblWord.setFont(Constants.FONT(30));

        JLabel lblHint = new JLabel("Hint");
        lblHint.setFont(Constants.FONT(30));
        
        JTextField txtWord = new JTextField();
        JTextField txtHint = new JTextField();
        
        JButton btnAddQuest = new JButton("Add");
        btnAddQuest.setFont(Constants.FONT(20));
        
        JButton btnRemoveQuest = new JButton("Remove");
        btnRemoveQuest.setFont(Constants.FONT(20));
        
        JButton btnBackToMenu = new JButton("Back to Menu");
        btnBackToMenu.setFont(Constants.FONT(20));
        
        lblQuestManager.setBounds(Constants.MID_SCREEN_X - 450, 60, 900, 100);
        lblWord.setBounds(20, 200, 100, 50);
        lblHint.setBounds(20, 350, 100, 50);
        
        txtWord.setBounds(20, 280, 300, 30);
        txtHint.setBounds(20, 430, 300, 30);

        btnRemoveQuest.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2 - 2*GAP_BUTTONS, 600 - 30, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnRemoveQuest.setBackground(COLOR_BUTTONS);

        btnAddQuest.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2 + 2*GAP_BUTTONS, 600 - 30, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnAddQuest.setBackground(COLOR_BUTTONS);

        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 300 - HEIGHT_BUTTONS - 30, 2*WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(new Color(193, 236, 228));

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                questManagerFrame.dispose();
            }
        });
        
        this.add(lblQuestManager);
        this.add(lblWord);
        this.add(lblHint);

        this.add(txtWord);
        this.add(txtHint);
        this.add(lblHint);

        this.add(btnRemoveQuest);
        this.add(btnAddQuest);
        this.add(btnBackToMenu);

        //adiciona palavras e dicas em quests.txt
        btnAddQuest.addActionListener(new ActionListener() {
            File file = new File("files//quests.txt");
            public void actionPerformed(ActionEvent e) {
                try{
                    String word = txtWord.getText().toLowerCase();
                    String hint = txtHint.getText().toLowerCase();
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                    
                    //remove caracteres inválidos e espaços repetidos
                    word = word.replaceAll("[^A-Za-z\\s]", "");
                    word = word.trim();
                    word = word.replaceAll("\\s+", " ");

                    hint = hint.replaceAll("[^A-Za-z\\s]", "");
                    hint = hint.trim();
                    hint = hint.replaceAll("\\s+", " ");

                    if(word.equals("")){
                        new PopupFrame("Erro", "Write a word.");
                    }
                    else if(hint.equals("")){
                        new PopupFrame("Erro", "Write a hint.");
                    }
                    else if(encontraString(word) != -1){
                        new PopupFrame("Erro", "Word already added.");
                    }
                    else{
                        writer.write(word + ";" + hint + "\n");
                        new PopupFrame("", "Word has been added.");
                    }
                    writer.close();
                }
                catch(Exception f) {
                    new PopupFrame("Error", "Some unexpected error occurred in Word Add.");
                }
            }
        });
        
        //remove palavra de quests.txt
        btnRemoveQuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File file = new File("files//quests.txt");
                try{
                    Scanner scan = new Scanner(file);
                    String word = txtWord.getText().toLowerCase();
                
                    //remove caracteres inválidos e espaços repetidos
                    word = word.replaceAll("[^A-Za-z\\s]", "");
                    word = word.trim();
                    word = word.replaceAll("\\s+", " ");

                    //talvez seja bom colocar uma frase na tela ao invés de escrever no terminal
                    int tam = encontraString(word);
                    
                    if(word.equals("")){
                        new PopupFrame("", "Write a word.");
                    }
                    else if(tam == -1){
                        new PopupFrame("", "Word not found.");
                    }
                    else{
                        String s = "";
                        for(int i=0; i<tam; i++){
                            s += scan.nextLine() + "\n";
                        }
                        scan.nextLine();
                        while(scan.hasNextLine()){
                            s += scan.nextLine() + "\n";
                        }
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        writer.write(s);
                        writer.close();
                        new PopupFrame("", "Word has been removed.");
                    }
                    scan.close();
                }
                catch(Exception f) {
                    new PopupFrame("", "Some unexpected error occurred in Word Removal.");
                }
            }
        });
    }

    //retorna a linha que tem a palavra se ela existe e -1 caso contrário
    public int encontraString(String s){
        File file = new File("files//quests.txt");
        try{
            int linha = -1;
            boolean ok = false;
            Scanner scan = new Scanner(file);
            
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
            if (ok) return linha;
            else return -1;
        }
        //se ocorreu algum erro
        catch (IOException e){
            new PopupFrame("", "Some unexpected error occurred in Reading File.");
            return -1;
        }
    }
}