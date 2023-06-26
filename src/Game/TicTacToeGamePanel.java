package Game;

import javax.swing.*;

import Constants.Constants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import Menu.MenuFrame;

public class TicTacToeGamePanel extends GamePanel <TicTacToeGameFrame>{
    private boolean turn; // true: X, false: O
    private ArrayList<JButton> squares;

    public TicTacToeGamePanel(TicTacToeGameFrame gameFrame) {
        super(gameFrame);
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);
        
        // Escolhe quem começa
        turn = true;
        Random random = new Random();
        int randomIndex = random.nextInt(2);
        turn = randomIndex == 0;
 
        squares = new ArrayList<>();

        // Texto do turno
        JLabel lblTurn = new JLabel("Turn of: " + (turn ? "X" : "O"), SwingConstants.CENTER);
        lblTurn.setFont(Constants.FONT(40));
        lblTurn.setBounds(0, Constants.HEIGHT_BUTTONS * 2 - Constants.MID_SCREEN_Y - Constants.VERTICAL_GAP_BUTTONS, Constants.SCREEN_X, Constants.SCREEN_Y);

        // Texto do Histórico
        JLabel lblHistory = new JLabel("X wins / O wins / Draws: " + TicTacToeManager.getHistory(), SwingConstants.CENTER);
        lblHistory.setFont(Constants.FONT(40));
        lblHistory.setBounds(0, Constants.HEIGHT_BUTTONS * 2 - Constants.MID_SCREEN_Y + Constants.VERTICAL_GAP_BUTTONS, Constants.SCREEN_X, Constants.SCREEN_Y);


        // Cria os botões para cada quadrado
        for (int i = 0; i < 9; ++i) {
            
            JButton newBtn = new JButton();
            newBtn.setBounds(450 - 130/2 + 2 * (i%3 - 1) * (Constants.HORIZONTAL_GAP_BUTTONS + 50), 450 - 130/2 + 2 * (i/3 - 1) * (Constants.VERTICAL_GAP_BUTTONS + 50) - 30, 130,130);
            newBtn.setBackground(Constants.COLOR_BUTTONS);
            newBtn.setFont(Constants.FONT(40));

            newBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /*
                     * Método acionado ao clicar em uma das casas
                     */ 
                    if (newBtn.getText().length() == 0) { // Ainda não foi usado
                        changeTurn(lblTurn, newBtn, turn);
                        turn = !turn;
                        checkIfFinished();
                    }    
                }    
            });    

            squares.add(newBtn);
            this.add(newBtn);
        }    
        

        // Reset button
        JButton btnReset = new JButton("Reset History");
        
        btnReset.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS/2 + Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 225, Constants.WIDTH_BUTTONS, Constants.HEIGHT_BUTTONS);
        btnReset.setBackground(Constants.COLOR_BUTTONS);
        
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TicTacToeManager.changeHistory('R');
                new TicTacToeGameFrame();
                gameFrame.dispose();
            }
        });

        // Back to Menu
        JButton btnBackToMenu = new JButton("Back to Menu");
        
        btnBackToMenu.setBounds(Constants.MID_SCREEN_X - Constants.WIDTH_BUTTONS/2 - Constants.WIDTH_BUTTONS, Constants.MID_SCREEN_Y + 225, Constants.WIDTH_BUTTONS, Constants.HEIGHT_BUTTONS);
        btnBackToMenu.setBackground(Constants.COLOR_BACK_BUTTON);
        
        btnBackToMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MenuFrame();
                gameFrame.dispose();
            }
        });
        
        this.add(btnBackToMenu);
        this.add(btnReset);
        this.add(lblHistory);
        this.add(lblTurn);
    }

    public void checkIfFinished() {
        int option = 3;

        boolean xWon = false, oWon = false;

        // Checa se se alguma linha está completa
        for (int i = 0; i < 9; i+=3) {
            if (
                squares.get(i).getText().equals("X") && 
                squares.get(i+1).getText().equals("X") &&
                squares.get(i+2).getText().equals("X")
                )
                xWon = true;
            else if (
                squares.get(i).getText().equals("O") && 
                squares.get(i+1).getText().equals("O") &&
                squares.get(i+2).getText().equals("O")
                )
                oWon = true;
        }

        // Checa se se alguma coluna está completa
        for (int i = 0; i < 3; ++i) {
            if (
                squares.get(i).getText().equals("X") && 
                squares.get(i+3).getText().equals("X") &&
                squares.get(i+6).getText().equals("X")
                )
                xWon = true;
            else if (
                squares.get(i).getText().equals("O") && 
                squares.get(i+3).getText().equals("O") &&
                squares.get(i+6).getText().equals("O")
                )
                oWon = true;
        }

        // Checa se alguma diagonal está completa

        if (
            squares.get(0).getText().equals("X") && 
            squares.get(4).getText().equals("X") &&
            squares.get(8).getText().equals("X")
            )
            xWon = true;
        else if (
            squares.get(0).getText().equals("O") && 
            squares.get(4).getText().equals("O") &&
            squares.get(8).getText().equals("O")
            )
            oWon = true;

        if (
            squares.get(2).getText().equals("X") && 
            squares.get(4).getText().equals("X") &&
            squares.get(6).getText().equals("X")
            )
            xWon = true;
        else if (
            squares.get(2).getText().equals("O") && 
            squares.get(4).getText().equals("O") &&
            squares.get(6).getText().equals("O")
            )
            oWon = true;

        // Checa se deu velha
        boolean allSquaresFilled = true;
        for (int i = 0; i < 9; ++i)
            if (squares.get(i).getText().equals(""))
                allSquaresFilled = false;

        if (xWon) {
            TicTacToeManager.changeHistory('X');
            option = JOptionPane.showConfirmDialog(null, "Player 1 wins! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
        } else if (oWon) {
            TicTacToeManager.changeHistory('O');
            option = JOptionPane.showConfirmDialog(null, "Player 2 wins! Would you like to play again?", "Nice!", JOptionPane.YES_NO_OPTION);
        } else if (allSquaresFilled) {
            TicTacToeManager.changeHistory('D');
            option = JOptionPane.showConfirmDialog(null, "Draw! Would you like to play again?", "Old woman", JOptionPane.YES_NO_OPTION);
        } else {
            return;
        }
        restart(option);
    }

    public void restart(int option) {
        /*
         * Reinicia o jogo
         */
        if (option == 3) return;
        if (option == 0)
            new TicTacToeGameFrame();
        else
            new MenuFrame();
        this.gameFrame.dispose();
    }

    public void changeTurn(JLabel lblTurn, JButton newBtn, boolean turn){
        if(turn){
            newBtn.setText("X");
            lblTurn.setText("Turn of: O");
        }
        else{
            newBtn.setText("O");
            lblTurn.setText("Turn of: X");
        }
    }
}
