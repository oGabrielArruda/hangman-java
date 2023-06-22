package Popup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopupPanel extends JPanel {
    public PopupPanel(PopupFrame popupFrame, String title, String content) {
        this.setLayout(null);
        this.setBackground(new Color(255, 208, 208));
        JLabel lblContent = new JLabel(content);
        lblContent.setBounds(0, 150, 450, 50);
        lblContent.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblContent);
    }
}
