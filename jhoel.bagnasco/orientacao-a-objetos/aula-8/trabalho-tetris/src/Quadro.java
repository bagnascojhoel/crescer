import blocos.*;
import blocos.Quadrado2x2;
import blocos.Quadrado3x3;
import excecoes.ReproducaoCanceladaPorOverflowException;

public class Quadro {

    private final boolean[][] quadro;
    private int pontuacao;
    private boolean erroOverflow;


    private static int LARGURA_MINIMA = 6;
    private static int ALTURA_MINIMA = 6;

    public Quadro(int largura, int altura){
        quadro = new boolean[Math.min(largura, LARGURA_MINIMA)][Math.min(altura, ALTURA_MINIMA)];
        pontuacao = -1;
        erroOverflow = false;
    }

    public boolean getErroOverflow() {
        return this.erroOverflow;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public int reproduzir(int quandidadePassos){
        for(int i=0; i<quandidadePassos && !erroOverflow;i++){
            Bloco bloco = gerarBloco();
            try {
                encaixarBloco(bloco);
            } catch (ReproducaoCanceladaPorOverflowException e){
                erroOverflow = true;
            }
        }

        this.pontuacao = contabilizarPontuacao();

        return this.pontuacao;
    }

    private void encaixarBloco(Bloco bloco) throws ReproducaoCanceladaPorOverflowException {
        int larguraInicio;
        int larguraDisponivel;

        for(int linha = 0; linha < this.quadro.length; linha++){

            int[] espacoEncontrado = encontrarEspacoNaLinha(this.quadro[linha], bloco);

            larguraInicio = espacoEncontrado[0];
            larguraDisponivel = espacoEncontrado[1];

            if(larguraDisponivel >= bloco.getLargura()) {
                inserirBloco(larguraInicio, linha, bloco);
                return;
            }
        }
    }

    private int[] encontrarEspacoNaLinha(boolean[] linha, Bloco bloco) {

        int larguraDisponivel = 1;
        int larguraInicio = -1;

        for (int i = 0; i < linha.length; i++) {
            if (!linha[i])
                if (larguraInicio == -1)
                    larguraInicio = i;
                else {
                    larguraDisponivel++;
                }
        }

        int[] retorno = {larguraInicio, larguraDisponivel};

        return retorno;
    }

    private void inserirBloco(int larguraInicio, int alturaInicio, Bloco bloco) throws ReproducaoCanceladaPorOverflowException {
        try {
            for (int j = alturaInicio; j < alturaInicio + bloco.getAltura(); j++)
                for (int i = larguraInicio; i < larguraInicio + bloco.getLargura(); i++)
                    this.quadro[j][i] = true;
        }catch (ArrayIndexOutOfBoundsException ae){
            throw new ReproducaoCanceladaPorOverflowException();
        }

    }

    private Bloco gerarBloco(){
        switch ((int) (Math.random() * 4 +1)){
            case 1:
                return new Quadrado2x2();

            case 2:
                return new Quadrado3x3();

            case 3:
                return new Retangulo3x1();

            default:
                return new Retangulo4x2();
        }
    }

    private int contabilizarPontuacao(){

        int pontuacao = 0;

        for(boolean[] linha : this.quadro){
            if(verificaLinha(linha))
                pontuacao++;
        }

        return pontuacao;
    }

    private boolean verificaLinha(boolean[] linha){
        for(boolean campo : linha)
            if(!campo)
                return false;
        return true;
    }
}
