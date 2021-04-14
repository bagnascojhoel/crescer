package blocos;

public abstract class Bloco {

    private int altura;

    private int largura;

    public Bloco(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
    }

    public void girar90Graus() {
        int swap = altura;
        altura = largura;
        largura = swap;
    }

    public int getAltura() {
        return altura;
    }

    public int getLargura() {
        return largura;
    }

}
