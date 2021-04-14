import org.junit.Test;

public class ExemploTiposPrimitivos {
    @Test
    public void declaracaoVariaveisPrimitivas() {
        int qtyBatatas = 24, batata = 5;
        System.out.println(qtyBatatas);
        System.out.println(batata);
    }

    @Test
    public void outrosTiposPrimitivos() {
        double pi = 3.14;
        System.out.println(pi);

        boolean corretorAtivo = true;
        System.out.println("O corretor esta ativo?");
        System.out.println(corretorAtivo);

        char primeiraLetraDoNome = 'a';
        System.out.println(primeiraLetraDoNome);
    }

    @Test
    public void copia() {
        int primeiroValor = 1;
        int segundoValor = primeiroValor;

        System.out.println(segundoValor);

        int minhaIdade = 18;
        int minhaIdadeAnoQueVem = minhaIdade + 1;
        System.out.println(minhaIdadeAnoQueVem);
    }

    @Test
    public void conversaoDeValores() {
        int saldoNaCarteira = 10;
        System.out.println("Valor na carteria: " + saldoNaCarteira);
    }

    @Test
    public void texto() {
        String meuNome = "Jojo galeano";
        System.out.println("Meu nome é: " + meuNome);

        int minhaIdade = 18;
        int minhaIdadeAnoQueVem = minhaIdade + 1;

        System.out.printf(
            "Minha idade é %d minha idade ano que vem será %d\n",
            minhaIdade,
            minhaIdadeAnoQueVem
        );
    }

    @Test
    public void constante() {
        final double PI = 3.14;
        double ratio = 2;
        double area = PI * ratio * ratio;

        System.out.println(area);
    }
}
