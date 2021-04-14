public class Jutsu {
    public static final int CUSTO_MAXIMO = 5;
    public static final int DANO_MAXIMO = 10;
    private int custo;
    private int dano;

    public Jutsu(int custo, int dano) {

        this.custo = custo > Jutsu.CUSTO_MAXIMO
                ? Jutsu.CUSTO_MAXIMO
                : (custo > 0 ? custo : 0);

        this.dano = dano > Jutsu.DANO_MAXIMO
                ? Jutsu.DANO_MAXIMO
                : (dano > 0 ? dano : 0);
    }

    public int getCusto() {
        return this.custo;
    }

    public int getDano() {
        return this.dano;
    }
}
