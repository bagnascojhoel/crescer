import axios from 'axios';

const mapRace = ({ id, nome, vidaBase, vigorBase, danoBase }) => ({
  id,
  name: nome,
  baseLife: vidaBase,
  baseStrength: vigorBase,
  baseDamage: danoBase,
});

const getRemoteRaces = async () => {
  try {
    const remoteRaces = await axios.get('http://tcc-js.surge.sh/races');

    // const remoteRaces = { data: mock };

    return remoteRaces.data;
  } catch (error) {
    throw `Error while trying to get races: ${error}`;
  }
};

export const getAllRaces = async () => {
  try {
    const remoteRaces = await getRemoteRaces();

    return remoteRaces.map(mapRace);
  } catch (error) {
    console.error(`Error while getting all races: ${error}`);
  }
};

export const getRaceById = async (askedId) => {
  try {
    const remoteRaces = await getRemoteRaces();
    const race = remoteRaces.find(({ id }) => id == askedId);

    return race ? mapRace(race) : null;
  } catch (error) {
    console.error(`Error while trying to get race by id: ${error}`);
  }
};

const mock = [
  {
    id: 1,
    nome: 'Elfo',
    vidaBase: 6,
    vigorBase: 3,
    danoBase: 5,
  },
  {
    id: 2,
    nome: 'Anão',
    vidaBase: 6,
    vigorBase: 5,
    danoBase: 3,
  },
  {
    id: 3,
    nome: 'Halfling',
    vidaBase: 5,
    vigorBase: 3,
    danoBase: 8,
  },
  {
    id: 4,
    nome: 'Humano',
    vidaBase: 5,
    vigorBase: 4,
    danoBase: 5,
  },
  {
    id: 5,
    nome: 'Goblin',
    vidaBase: 4,
    vigorBase: 2,
    danoBase: 8,
  },
  {
    id: 6,
    nome: 'Gnomo',
    vidaBase: 3,
    vigorBase: 5,
    danoBase: 6,
  },
  {
    id: 7,
    nome: 'Orc',
    vidaBase: 6,
    vigorBase: 4,
    danoBase: 4,
  },
  {
    id: 8,
    nome: 'Meio Elfo',
    vidaBase: 5,
    vigorBase: 4,
    danoBase: 6,
  },
];
