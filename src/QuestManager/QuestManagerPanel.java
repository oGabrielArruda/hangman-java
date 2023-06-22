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

import Menu.MenuFrame;

public class QuestManagerPanel extends JPanel {

    private static final int MID_SCREEN_X = 450;
    private static final int MID_SCREEN_Y = 450;
    private static final int GAP_BUTTONS = 100;
    private static final  int WIDTH_BUTTONS = 100;
    private static final int HEIGHT_BUTTONS = 50;
    private static final Color COLOR_BUTTONS = new Color(255, 158, 170);

    public QuestManagerPanel() {
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));

        JLabel lblQuestManager = new JLabel("Quest Manager");
        JLabel lblWord = new JLabel("Word");
        JLabel lblHint = new JLabel("Hint");

        JTextField txtWord = new JTextField();
        JTextField txtHint = new JTextField();

        JButton btnOpenFile = new JButton("Open");
        JButton btnAddQuest = new JButton("Add");
        JButton btnRemoveQuest = new JButton("Remove");
        JButton btnSaveFile = new JButton("Save");
        JButton btnBackToMenu = new JButton("Back to Menu");

        lblQuestManager.setBounds(MID_SCREEN_X - 55, 60, 110, 100);
        lblWord.setBounds(20, 200, 100, 50);
        lblHint.setBounds(20, 350, 100, 50);

        txtWord.setBounds(20, 280, 300, 30);
        txtHint.setBounds(20, 430, 300, 30);

        btnRemoveQuest.setBounds(MID_SCREEN_X - 3*GAP_BUTTONS/2 - 2*WIDTH_BUTTONS, 600, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnRemoveQuest.setBackground(COLOR_BUTTONS);

        btnAddQuest.setBounds(MID_SCREEN_X - GAP_BUTTONS/2 - WIDTH_BUTTONS, 600, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnAddQuest.setBackground(COLOR_BUTTONS);

        btnSaveFile.setBounds(MID_SCREEN_X + GAP_BUTTONS/2, 600, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnSaveFile.setBackground(COLOR_BUTTONS);

        btnOpenFile.setBounds(MID_SCREEN_X + 3*GAP_BUTTONS/2 + WIDTH_BUTTONS, 600, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnOpenFile.setBackground(COLOR_BUTTONS);

        btnBackToMenu.setBounds(MID_SCREEN_X - WIDTH_BUTTONS, MID_SCREEN_Y + 300 - HEIGHT_BUTTONS, 2*WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(new Color(193, 236, 228));

        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
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
        this.add(btnSaveFile);
        this.add(btnOpenFile);
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

                    //talvez seja bom colocar uma frase na tela ao invés de escrever no terminal
                    if(word.equals("")){
                        System.out.println("Escreva uma palavra.");
                    }
                    else if(hint.equals("")){
                        System.out.println("Escreva uma dica.");
                    }
                    else if(encontraString(word) != -1){
                        System.out.println("Palavra já adicionada.");
                    }
                    else{
                        writer.write(word + ";" + hint + "\n");
                        System.out.println("Palavra adicionada.");
                    }
                    writer.close();
                }
                catch(Exception f) {
                    System.out.println("Algum erro inesperado ocorreu na Adição de Palavra.");
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
                        System.out.println("Escreva uma palavra.");
                    }
                    else if(tam == -1){
                        System.out.println("Palavra não encontrada.");
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
                        System.out.println("Palavra removida.");
                    }
                    scan.close();
                }
                catch(Exception f) {
                    System.out.println("Algum erro inesperado ocorreu na Remoção de Palavra.");
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
            System.out.println("Algum erro inesperado ocorreu na leitura do Arquivo.");
            return -1;
        }
    }
}