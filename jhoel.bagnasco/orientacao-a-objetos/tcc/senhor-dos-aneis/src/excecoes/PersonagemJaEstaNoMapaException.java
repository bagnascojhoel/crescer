package excecoes;

public class PersonagemJaEstaNoMapaException extends Exception {
    public PersonagemJaEstaNoMapaException() {
        super("O personagem dado já existe no mapa.");
    }
}
