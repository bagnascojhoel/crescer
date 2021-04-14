import '@babel/polyfill';
import axios from 'axios';
import { getAllQuests, getQuestById } from '../../src/services';

jest.mock('axios');

describe('Suíte: repositório de missão', () => {
  beforeEach(() => {
    const quests = [
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
    ];

    const response = { data: quests };

    axios.get.mockResolvedValue(response);
  });

  it('Deve ser todas missões disponíveis quando buscar todas missões', async () => {
    const expectedQuests = [
      {
        id: 5,
        description: 'Defender uma cidade de ataques de Worgs',
        estimatedTime: 90000,
        receivedLevels: 3,
        receivedGold: 70,
      },
      {
        id: 6,
        description:
          'Vencer o campeonato de quem bebe mais cerveija amanteigada',
        estimatedTime: 120000,
        receivedLevels: 1,
        receivedGold: 100,
      },
      {
        id: 7,
        description: 'Derrotar o Lich',
        estimatedTime: 300000,
        receivedLevels: 8,
        receivedGold: 170,
      },
    ];

    const receivedQuests = await getAllQuests();

    expect(receivedQuests).toEqual(expectedQuests);
  });

  it('Deve ser a missão correta quando buscar missão por id', async () => {
    const expectedQuest = {
      id: 6,
      description: 'Vencer o campeonato de quem bebe mais cerveija amanteigada',
      estimatedTime: 120000,
      receivedLevels: 1,
      receivedGold: 100,
    };

    const receivedQuest = await getQuestById(6);

    expect(receivedQuest).toEqual(expectedQuest);
  });
});
