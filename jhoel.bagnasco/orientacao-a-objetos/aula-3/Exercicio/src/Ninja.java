public class Ninja {
    private String nome;
    private int chakra = 100;
    private Jutsu jutsu;

    public Ninja(String nome, Jutsu jutsu) {
        this.nome = nome;
        this.jutsu = jutsu;
    }

    public void atacar(Ninja oponente) {
        this.receberGolpe(this.jutsu.getCusto());

        oponente.receberGolpe(this.jutsu.getDano());
    }

    private void receberGolpe(int danoAReceber) {
        this.chakra -= danoAReceber;
    }

    public String getNome() {
        return this.nome;
    }

    public int getChakra() {
        return this.chakra;
    }
}
