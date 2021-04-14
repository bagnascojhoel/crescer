import pokemonsList from '../pokemons';

function pokemonAleatorio() {
  return pokemonsList[Math.floor(Math.random() * pokemonsList.length)];
}

function iniciarPokemon(pokemon) {
  return {
    ...pokemon,
    level: pokemon.levelInicial,
  }
}

export function criarPokemon() {
  const pokemon = pokemonAleatorio();
  return iniciarPokemon(pokemon);
}

export function incrementarLevelPokemon(pokemon) {
  const level = pokemon.level + 1;

  return { ...pokemon, level };
}

export function aptoAEvoluir(pokemon) {
  return pokemon.level >= pokemon.evolucao.level;
}

export function evoluirPokemon(pokemon) {
  if (!pokemon.evolucao) return pokemon;
  if (!aptoAEvoluir(pokemon)) return pokemon;

  const pokemonEvoluido = pokemonsList.find(
    (pokemonAtual) => pokemonAtual.id == pokemon.evolucao.id
  );

  return iniciarPokemon(pokemonEvoluido);
}
