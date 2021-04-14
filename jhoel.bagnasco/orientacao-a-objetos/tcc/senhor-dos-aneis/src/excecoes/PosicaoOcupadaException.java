package excecoes;

public class PosicaoOcupadaException extends Exception {
    public PosicaoOcupadaException() {
        super("Ja existe um personagem na posição dada.");
    }
}
