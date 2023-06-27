package Game;
import Constants.Constants;

/*
 * Enum de imagens. Usadas para a forca, mas o enum é genérico o suficiente para ser usado em outros contextos.
 * Temos um path, uma posX e uma posY
 */
public enum Image {
    CABECA("utils/assets/images/cabeca.gif", Constants.MID_SCREEN_X - 4, Constants.MID_SCREEN_Y - 150),
    QUEIXO("utils/assets/images/queixo.gif", Constants.MID_SCREEN_X, Constants.MID_SCREEN_Y - 110),
    TRONCO("utils/assets/images/tronco.gif", Constants.MID_SCREEN_X, Constants.MID_SCREEN_Y - 102),
    CINTURA("utils/assets/images/cintura.gif", Constants.MID_SCREEN_X, Constants.MID_SCREEN_Y - 61),
    MAO_DIREITA("utils/assets/images/mao_direita.gif", Constants.MID_SCREEN_X + 32, Constants.MID_SCREEN_Y - 102),
    MAO_ESQUERDA("utils/assets/images/mao_esquerda.gif", Constants.MID_SCREEN_X - 29, Constants.MID_SCREEN_Y - 110),
    PE_DIREITO("utils/assets/images/pe_direito.gif", Constants.MID_SCREEN_X + 18, Constants.MID_SCREEN_Y - 36),
    PE_ESQUERDO("utils/assets/images/pe_esquerdo.gif", Constants.MID_SCREEN_X - 18, Constants.MID_SCREEN_Y - 36);

    private String imagePath;
    private int xCoordinate;
    private int yCoordinate;

    Image(String imagePath, int xCoordinate, int yCoordinate) {
        this.imagePath = imagePath;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }
}