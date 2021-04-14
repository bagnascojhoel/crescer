package excecoes;

public class PersonagemNaoEncontradoNoMapaException extends Exception {
    public PersonagemNaoEncontradoNoMapaException() {
        super("O personagem dado não existe no mapa.");
    }
}
