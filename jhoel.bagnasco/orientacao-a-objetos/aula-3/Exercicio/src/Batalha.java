public class Batalha {
    private final String NOME_DO_NINJA_MAIS_PODEROSO = "Itachi";

    public Ninja lutar(Ninja ninjaLocal, Ninja ninjaDesafiante) {
      if (ehONinjaMaisPoderoso(ninjaLocal)) return ninjaLocal;
      if (ehONinjaMaisPoderoso(ninjaDesafiante)) return ninjaDesafiante;

      for (short i = 3; i > 0; i--) {
          ninjaLocal.atacar(ninjaDesafiante);
          ninjaDesafiante.atacar(ninjaLocal);
      }

      if (ninjaLocal.getChakra() >= ninjaDesafiante.getChakra()) {
          return ninjaLocal;
      } else {
          return ninjaDesafiante;
      }
    }

    private boolean ehONinjaMaisPoderoso(Ninja ninja) {
        return (ninja.getNome() == NOME_DO_NINJA_MAIS_PODEROSO);
    }
}
