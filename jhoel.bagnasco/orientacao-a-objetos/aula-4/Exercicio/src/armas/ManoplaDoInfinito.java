package armas;

public class ManoplaDoInfinito extends Arma {
    private static final int DANO_BASE = Integer.MAX_VALUE;

    public ManoplaDoInfinito() {
        super(DANO_BASE);
    }
}
