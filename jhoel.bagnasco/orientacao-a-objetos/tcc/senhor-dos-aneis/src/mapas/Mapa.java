package mapas;

import excecoes.PersonagemJaEstaNoMapaException;
import excecoes.PersonagemNaoEncontradoNoMapaException;
import excecoes.PosicaoOcupadaException;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Mapa {

    private static final int TAMANHO_DO_MAPA = 10;

    private static final String ESPACO = " ";

    private static final String DIVISOR = "|";

    private final List<Personagem> posicoes;

    public Mapa() {
        this.posicoes = new ArrayList<>();
        for (int i = TAMANHO_DO_MAPA; i > 0; i--)
            posicoes.add(null);

    }

    public String exibir() {
        List<String> mapaParaExibir = posicoes.stream()
                .map((p) -> p == null ? ESPACO : p.toString())
                .collect(Collectors.toList());

        return mapaParaExibir.stream()
                .reduce(DIVISOR, (acc, s) -> acc += s + DIVISOR);
    }

    public void inserir(int posicao, Personagem personagem) throws PosicaoOcupadaException, PersonagemJaEstaNoMapaException {
        if (!verSePosicaoVazia(posicao)) throw new PosicaoOcupadaException();
        if (personagemJaNoMapa(personagem)) throw new PersonagemJaEstaNoMapaException();

        if (personagem.estaVivo())
            posicoes.set(posicao, personagem);
    }

    public void remover(int posicao) {
        posicoes.set(posicao, null);
    }

    public int buscarPosicao(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException {
        int resultadoDaBusca = posicoes.indexOf(personagem);
        if (resultadoDaBusca == -1) throw new PersonagemNaoEncontradoNoMapaException();

        return resultadoDaBusca;
    }

    public Personagem buscarCasa(int posicao) {
        return posicoes.get(posicao);
    }

    public List<Personagem> getPosicoes() {
        return posicoes;
    }

    public int moverPersonagem(Personagem personagem) throws PersonagemNaoEncontradoNoMapaException, PersonagemJaEstaNoMapaException, PosicaoOcupadaException {
        int posicaoAtual = buscarPosicao(personagem);
        int posicaoDestino = buscarPosicaoRelativa(personagem, 1);

        if (!verSePosicaoExiste(posicaoDestino) || !verSePosicaoVazia(posicaoDestino)) return posicaoAtual;

        remover(buscarPosicao(personagem));
        inserir(posicaoDestino, personagem);
        return posicaoDestino;
    }

    // TODO testar isso
    public int buscarPosicaoRelativa(Personagem p, int distancia) throws PersonagemNaoEncontradoNoMapaException {
        int posicaoAtual = buscarPosicao(p);
        int posicaoFinal = p.pertenceASociedadeDoAnel() ? posicaoAtual + distancia : posicaoAtual - distancia;

        return verSePosicaoExiste(posicaoFinal) ? posicaoFinal : -1;
    }

    private boolean verSePosicaoVazia(int posicao) {
        return posicoes.get(posicao) == null;
    }

    private boolean verSePosicaoExiste(int posicao) {
        int ultimaPosicao = TAMANHO_DO_MAPA - 1;
        return posicao <= ultimaPosicao && posicao >= 0;
    }

    private boolean personagemJaNoMapa(Personagem personagem) {
        return posicoes.indexOf(personagem) > -1;
    }

}
