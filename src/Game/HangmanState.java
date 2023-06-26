package Game;

public enum HangmanState {
    HEAD,
    BODY,
    RIGHT_ARM,
    LEFT_ARM,
    RIGHT_LEG,
    LEFT_LEG,
    HANGED;

    HangmanState() {}

    // método utilizado para passarmos para a próxima parte do corpo
    public static HangmanState nextBodyPart(HangmanState state) {
        return HangmanState.values()[state.ordinal()+1];
    }
}
