import {
  aptoAEvoluir,
  criarPokemon,
  evoluirPokemon,
  incrementarLevelPokemon
} from '../../src';

describe('Suite - pokemon', () => {
  it('deve possuir level quando criar pokemon', () => {
    const pokemonObtido = criarPokemon();

    expect(pokemonObtido).toHaveProperty('level');
  });

  // it('deve aumentar o nivel do pokemon quando evoluir pokemon', () => { // algum é preferível?
  it('deve aumentar o nível do pokemon', () => {
    const pokemonBase = criarPokemon();
    const pokemonEsperado = {
      ...pokemonBase,
      level: pokemonBase.levelInicial + 1,
    };

    const pokemonObtido = incrementarLevelPokemon(pokemonBase);

    expect(pokemonObtido).toEqual(pokemonEsperado);
  });

  it('deve ser verdadeiro quando pokemon estiver com level igual ao seu nivel de evolução', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 5,
      level: 10,
      evolucao: {
        level: 10,
        id: 3,
      },
    };
    const resultado = aptoAEvoluir(pokemonBase);

    expect(resultado).toBe(true);
  });

  it('deve ser verdadeiro quando pokemon estiver com level maior que seu nível de evolução', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 5,
      level: 20,
      evolucao: {
        level: 10,
        id: 3,
      },
    };
    const resultado = aptoAEvoluir(pokemonBase);

    expect(resultado).toBe(true);
  });

  it('deve ser falso quando pokemon não estiver apto a evoluir', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 5,
      level: 6,
      evolucao: {
        level: 10,
        id: 3,
      },
    };
    const resultado = aptoAEvoluir(pokemonBase);

    expect(resultado).toBe(false);
  });

  it('deve evoluir quando pokemon estiver possuir evolução e estiver apto', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 5,
      level: 10,
      evolucao: {
        level: 10,
        id: 3,
      },
    };

    const pokemonEsperado = {
      id: 3,
      nome: 'Blastoise',
      poderAtaque: 100,
      levelInicial: 10,
      level: 10,
      evolucao: null,
    };

    const pokemonObtido = evoluirPokemon(pokemonBase);

    expect(pokemonObtido).toEqual(pokemonEsperado);
  });

  it('deve não evoluir quando não está apto e possuir evolução', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 5,
      level: 5,
      evolucao: {
        level: 10,
        id: 4,
      }
    };
    
    const pokemonEsperado = pokemonBase;

    const pokemonObtido = evoluirPokemon(pokemonBase);

    expect(pokemonObtido).toEqual(pokemonEsperado);
  });

  it('deve não evoluir quando não possuir evolução', () => {
    const pokemonBase = {
      id: 2,
      nome: 'Joao',
      poderAtaque: 10,
      levelInicial: 10,
      level: 15,
      evolucao: null
    };
    
    const pokemonEsperado = pokemonBase;

    const pokemonObtido = evoluirPokemon(pokemonBase);

    expect(pokemonObtido).toEqual(pokemonEsperado);
  });
});
