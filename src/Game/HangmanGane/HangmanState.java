package Game.HangmanGane;

import java.util.HashSet;
import java.util.Set;

import Game.Image;

/*
 * Enum para controlar o estado da forca
 * Cada estado tem imagens correspondentes
 */
public enum HangmanState {
    HEAD(Image.CABECA, Image.QUEIXO),
    BODY(Image.TRONCO, Image.CINTURA),
    RIGHT_ARM(Image.MAO_DIREITA),
    LEFT_ARM(Image.MAO_ESQUERDA),
    RIGHT_LEG(Image.PE_DIREITO),
    LEFT_LEG(Image.PE_ESQUERDO),
    HANGED();

    private Set<Image> images;
    HangmanState(Image... images) {
        this.images = new HashSet<>();
        for (Image image : images) {
            this.images.add(image);
        }
    }

    // método utilizado para passarmos para a próxima parte do corpo
    public static HangmanState nextBodyPart(HangmanState state) {
        return HangmanState.values()[state.ordinal()+1];
    }

    public Set<Image> getImages() {
        return this.images;
    }
}
