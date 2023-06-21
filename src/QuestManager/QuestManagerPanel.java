package QuestManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    }
}
