import {
  criarPokemon,
  evoluirPokemon,
  incrementarLevelPokemon
} from './pokemon';

export function criarTreinador(nome, idade) {
  const pokemonInicial = criarPokemon();
  const pokemons = [pokemonInicial];

  return { nome, idade, pokemons };
}

function incrementarLevelPokemons(treinador) {
  const pokemons = treinador.pokemons.map((pokemon) =>
    incrementarLevelPokemon(pokemon)
  );
  
  return {
    ...treinador,
    pokemons,
  };
}

function evoluirPokemons(treinador) {
  const pokemons = treinador.pokemons.map((pokemon) => evoluirPokemon(pokemon));
  return {
    ...treinador,
    pokemons,
  };
}

function adicionarPokemon(treinador, pokemon) {
  const pokemons = [...treinador.pokemons, pokemon];

  return {
    ...treinador,
    pokemons,
  };
}

export function capturarPokemon(treinador, pokemon) {
  let treinadorEmCaptura = { ...treinador };
  treinadorEmCaptura = incrementarLevelPokemons(treinadorEmCaptura);
  treinadorEmCaptura = evoluirPokemons(treinadorEmCaptura);
  const treinadorAposCaptura = adicionarPokemon(treinadorEmCaptura, pokemon);

  return treinadorAposCaptura;
}
