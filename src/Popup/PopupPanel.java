package Popup;

import Constants.Constants;
import javax.swing.*;

/*
 * Classe de Popups
 */

public class PopupPanel extends JPanel {
    public PopupPanel(PopupFrame popupFrame, String title, String content) {
        this.setLayout(null);
        this.setBackground(Constants.COLOR_BACKGROUND);
        JLabel lblContent = new JLabel(content);
        lblContent.setBounds(0, Constants.MID_SCREEN_Y/3, Constants.MID_SCREEN_X, Constants.HEIGHT_BUTTONS);
        lblContent.setHorizontalAlignment(SwingConstants.CENTER);
        lblContent.setFont(Constants.FONT(15));
        this.add(lblContent);
    }
}
