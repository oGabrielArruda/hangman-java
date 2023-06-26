package Constants;
import java.awt.*;

/*
 * Arquivo com as constantes utilizadas.
 */

public class Constants {
    public static final int SCREEN_X = 900;
    public static final int SCREEN_Y = 900;
    public static final int MID_SCREEN_X = SCREEN_X/2;
    public static final int MID_SCREEN_Y = SCREEN_Y/2;
    public static final int WIDTH_BUTTONS = 150;
    public static final int HEIGHT_BUTTONS = 50;
    public static final int HORIZONTAL_GAP_BUTTONS = 30;
    public static final int VERTICAL_GAP_BUTTONS = 30;
    public static final Color COLOR_BUTTONS = new Color(255, 158, 170);
    public static final Color COLOR_BACKGROUND = new Color(255, 208, 208);
    public static final Color COLOR_BACK_BUTTON = new Color(193, 236, 228);
    public static final String QUESTS_PATH = "files//quests.txt";

    public static final Font FONT(int size){
        return new Font("Comic Sans MS", Font.PLAIN, size);
    }
}
