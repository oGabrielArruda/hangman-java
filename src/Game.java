import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.io.IOException;

public class Game extends JFrame {

    private JPanel pnlGame;
    private JPanel pnlHangman;
    private JPanel pnlWordArea;
    private JPanel pnlWordLetters;
    private JPanel pnlHint;
    private JButton btnMenu;
    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnD;
    private JButton btnE;
    private JButton btnF;
    private JButton btnG;
    private JButton btnH;
    private JButton btnI;
    private JButton btnJ;
    private JButton btnK;
    private JButton btnL;
    private JButton btnM;
    private JButton btnN;
    private JButton btnO;
    private JButton btnP;
    private JButton btnQ;
    private JButton btnR;
    private JButton btnS;
    private JButton btnT;
    private JButton btnU;
    private JButton btnV;
    private JButton btnW;
    private JButton btnX;
    private JButton btnY;
    private JButton btnZ;
    private JLabel lblFirstHint;
    private JLabel lblSecondHint;

    public class pnlHangman extends JPanel {
        private BufferedImage hangman;
        public pnlHangman() {
            try {
                BufferedImage hangman = ImageIO.read(this.getClass().getResource("./utils/assets/images/Enforcado.gif"));
                JLabel wIcon = new JLabel(new ImageIcon(hangman));
            } catch (IOException error) {
                System.err.println(error.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(hangman, 0, 0, this);
        }
    }

    public Game() {
        //new pnlHangman();

        setContentPane(pnlGame);
        setTitle("Hangman Game");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Main().setVisible(true);
                dispose();
            }
        });
    }
}
