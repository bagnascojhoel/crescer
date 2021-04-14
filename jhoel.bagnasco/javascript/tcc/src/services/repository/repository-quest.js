import axios from 'axios';

const mapQuest = ({
  id,
  descricao,
  tempoEstimado,
  niveisRecebidos,
  dinheiroRecebido,
}) => ({
  id,
  description: descricao,
  estimatedTime: tempoEstimado,
  receivedLevels: niveisRecebidos,
  receivedGold: dinheiroRecebido,
});

const getRemoteQuests = async () => {
  try {
    const remoteQuests = await axios.get('http://tcc-js.surge.sh/quests');
    // const remoteQuests = { data: mock };

    return remoteQuests.data;
  } catch (error) {
    throw `Error while trying to get quests: ${error}`;
  }
};

export const getAllQuests = async () => {
  try {
    const remoteQuests = await getRemoteQuests();

    return remoteQuests.map(mapQuest);
  } catch (error) {
    console.error(`Error while getting all quests: ${error}`);
  }
};

export const getQuestById = async (askedId) => {
  try {
    const remoteQuests = await getRemoteQuests();
    const quest = remoteQuests.find(({ id }) => id == askedId);

    return quest ? mapQuest(quest) : null;
  } catch (error) {
    console.error(`Error while trying to get quest by id: ${error}`);
  }
};

const mock = [
  {
    id: 1,
    descricao: 'Limpar os canecos da taberna',
    tempoEstimado: 5000,
    niveisRecebidos: 0,
    dinheiroRecebido: 10,
  },
  {
    id: 2,
    descricao: 'Limpar a taberna',
    tempoEstimado: 15000,
    niveisRecebidos: 0,
    dinheiroRecebido: 20,
  },
  {
    id: 3,
    descricao: 'Batalhar contra Murloc',
    tempoEstimado: 20000,
    niveisRecebidos: 1,
    dinheiroRecebido: 0,
  },
  {
    id: 4,
    descricao: 'Batalhar contra Ogro',
    tempoEstimado: 30000,
    niveisRecebidos: 2,
    dinheiroRecebido: 0,
  },
  {
    id: 5,
    descricao: 'Defender uma cidade de ataques de Worgs',
    tempoEstimado: 90000,
    niveisRecebidos: 3,
    dinheiroRecebido: 70,
  },
  {
    id: 6,
    descricao: 'Vencer o campeonato de quem bebe mais cerveija amanteigada',
    tempoEstimado: 120000,
    niveisRecebidos: 1,
    dinheiroRecebido: 100,
  },
  {
    id: 7,
    descricao: 'Derrotar o Lich',
    tempoEstimado: 300000,
    niveisRecebidos: 8,
    dinheiroRecebido: 170,
  },
  {
    id: 8,
    descricao: 'Capturar um Dragão',
    tempoEstimado: 1800000,
    niveisRecebidos: 17,
    dinheiroRecebido: 400,
  },
  {
    id: 9,
    descricao: 'Expulsar legião',
    tempoEstimado: 2600000,
    niveisRecebidos: 24,
    dinheiroRecebido: 800,
  },
];
