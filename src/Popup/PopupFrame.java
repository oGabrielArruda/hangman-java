package Popup;

import javax.swing.*;

public class PopupFrame extends JFrame {
    public PopupFrame(String title, String content) {
        this.add(new PopupPanel(this, title, content));
        this.setTitle("Warning");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(450, 450);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
