package QuestManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Constants.Constants;
import Menu.MenuFrame;
import manager.QuestManager;

public class QuestManagerPanel extends JPanel {
    private static final int GAP_BUTTONS = 100;
    private static final int WIDTH_BUTTONS = 200;
    private static final int HEIGHT_BUTTONS = 50;

    //Constructor
    public QuestManagerPanel(QuestManagerFrame questManagerFrame) {
        //VISUAL

        //no layout
        this.setLayout(null);

        //set background color
        this.setBackground(Constants.COLOR_BACKGROUND);
        
        //title text
        JLabel lblQuestManager = new JLabel("Quest Manager", SwingConstants.CENTER);
        lblQuestManager.setFont(Constants.FONT(40));
        lblQuestManager.setBounds(Constants.MID_SCREEN_X - 450, 60, 900, 100);

        //word text
        JLabel lblWord = new JLabel("Word");
        lblWord.setFont(Constants.FONT(30));
        lblWord.setBounds(20, 200, 100, 50);

        //write word area
        JTextField txtWord = new JTextField();
        txtWord.setBounds(20, 280, 300, 30);

        //hint text
        JLabel lblHint = new JLabel("Hint");
        lblHint.setFont(Constants.FONT(30));
        lblHint.setBounds(20, 350, 100, 50);
        
        //write hint area
        JTextField txtHint = new JTextField();
        txtHint.setBounds(20, 430, 300, 30);
        
        //set add button
        JButton btnAddQuest = new JButton("Add");
        btnAddQuest.setFont(Constants.FONT(20));
        btnAddQuest.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2 + 2*GAP_BUTTONS, 600 - 30, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnAddQuest.setBackground(Constants.COLOR_BUTTONS);
        
        //set remove button
        JButton btnRemoveQuest = new JButton("Remove");
        btnRemoveQuest.setFont(Constants.FONT(20));
        btnRemoveQuest.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS/2 - 2*GAP_BUTTONS, 600 - 30, WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnRemoveQuest.setBackground(Constants.COLOR_BUTTONS);
        
        //set back to menu button
        JButton btnBackToMenu = new JButton("Back to Menu");
        btnBackToMenu.setFont(Constants.FONT(20));
        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 300 - HEIGHT_BUTTONS - 30, 2*WIDTH_BUTTONS, HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(Constants.COLOR_BACK_BUTTON);


        //FUNCTIONS

        //back to menu
        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                questManagerFrame.dispose();
            }
        });
        
        //add a quest to quests.txt
        btnAddQuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QuestManager.addWord(txtWord.getText().toLowerCase(), txtHint.getText().toLowerCase());
            }
        });

        //remove a word from quests.txt
        btnRemoveQuest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                QuestManager.removeWord(txtWord.getText().toLowerCase());
            }
        });
       
        //add labels
        this.add(lblQuestManager);
        this.add(lblWord);
        this.add(lblHint);

        //add texts
        this.add(txtWord);
        this.add(txtHint);

        //add buttons
        this.add(btnRemoveQuest);
        this.add(btnAddQuest);
        this.add(btnBackToMenu);
    }
}