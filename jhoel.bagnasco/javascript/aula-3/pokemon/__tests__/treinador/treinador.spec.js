import {
  capturarPokemon,
  criarPokemon,
  criarTreinador
} from '../../src';

describe('Suite - treinador', () => {
  it('deve criar treinador com um pokemon inicial', () => {
    const tamanhoEsperado = 1;

    // act
    const treinador = criarTreinador('Jonana', 23);
    const tamanhoObtido = treinador.pokemons.length;

    expect(tamanhoObtido).toBe(tamanhoEsperado);
  });

  it('deve incrementar em um o level dos pokemons já capturados quando capturar outro', () => {
    const pokemonUm = {
      id: 2,
      nome: 'Wartortle',
      poderAtaque: 10,
      levelInicial: 5,
      level: 9,
      evolucao: {
        level: 10,
        id: 3,
      },
    };
    const pokemonDois = {
      id: 3,
      nome: 'Blastoise',
      poderAtaque: 100,
      levelInicial: 10,
      level: 10,
      evolucao: null,
    };
    const treinador = {
      nome: 'Joao',
      idade: 43,
      pokemons: [pokemonUm, pokemonDois],
    };
    const pokemonCapturado = criarPokemon();
    const pokemonsEsperados = [pokemonUm.level +1, pokemonDois.level +1, pokemonCapturado.level];

    const pokemonsObtidos = capturarPokemon(treinador, pokemonCapturado)
      .pokemons.map(({level}) => level);

    expect(pokemonsObtidos.sort()).toEqual(pokemonsEsperados.sort());
  });

  it('deve evoluir os pokemons já capturados e aptos quando capturar outro', () => {
    const pokemonUm = {
      id: 2,
      nome: 'Wartortle',
      poderAtaque: 10,
      levelInicial: 5,
      level: 10,
      evolucao: {
        level: 10,
        id: 3,
      },
    };

    const pokemonUmEvoluido = {
      id: 3,
      nome: 'Blastoise',
      poderAtaque: 100,
      levelInicial: 10,
      level: 10,
      evolucao: null,
    };

    const treinador = {
      nome: 'Joao',
      idade: 43,
      pokemons: [pokemonUm],
    };

    const pokemonCapturado = criarPokemon();
    const pokemonsEsperados = [pokemonUmEvoluido, pokemonCapturado];

    const pokemonsObtidos = capturarPokemon(treinador, pokemonCapturado)
      .pokemons;

    expect(pokemonsObtidos).toEqual(pokemonsEsperados);
  });

  it('deve adicionar pokemon capturado a lista de pokemons quando capturar', () => {
    const treinador = {
      nome: 'Joao',
      idade: 43,
      pokemons: [criarPokemon(), criarPokemon()],
    };
    const pokemonCapturado = criarPokemon();
    const quantidadeDePokemonsEsperada = 3;

    const treinadorAposCaptura = capturarPokemon(treinador, pokemonCapturado);
    const quantidadeDePokemonsObtida = treinadorAposCaptura.pokemons.length;

    expect(quantidadeDePokemonsObtida).toEqual(quantidadeDePokemonsEsperada);
  });
});
