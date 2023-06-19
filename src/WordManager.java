import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordManager extends JFrame {
    private JTextField txtHint;
    private JTextField txtWord;
    private JLabel lblWord;
    private JLabel lblHint;
    private JButton btnAddWord;
    private JButton btnRemoveWord;
    private JButton btnSaveFile;
    private JPanel pnlWordManager;
    private JButton btnMenu;

    public WordManager() {
        setContentPane(pnlWordManager);
        setTitle("Hangman Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        btnAddWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for adding word goes here
            }
        });

        btnRemoveWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for deleting word goes here
            }
        });

        btnSaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code for saving file goes here
            }
        });

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });
    }
}
