package trajetos;

public class Curva extends Trajeto {
    private static final int MULTIPLICADOR_DE_DIFICULDADE = 2;

    public Curva(int dificuldade) {
        super(dificuldade * MULTIPLICADOR_DE_DIFICULDADE);
    }
}
