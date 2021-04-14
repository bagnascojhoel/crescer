import '@babel/polyfill';
import axios from 'axios';
import { getAllRaces, getRaceById } from '../../src/services';

jest.mock('axios');

describe('Suíte: repositório de raças', () => {
  beforeEach(() => {
    const races = [
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
        id: 8,
        nome: 'Meio Elfo',
        vidaBase: 5,
        vigorBase: 4,
        danoBase: 6,
      },
    ];

    const response = { data: races };

    axios.get.mockResolvedValue(response);
  });

  it('Deve ser todas raças quando buscar todas racas', async () => {
    const expectedRaces = [
      {
        id: 1,
        name: 'Elfo',
        baseLife: 6,
        baseStrength: 3,
        baseDamage: 5,
      },
      {
        id: 2,
        name: 'Anão',
        baseLife: 6,
        baseStrength: 5,
        baseDamage: 3,
      },
      {
        id: 8,
        name: 'Meio Elfo',
        baseLife: 5,
        baseStrength: 4,
        baseDamage: 6,
      },
    ];

    const receivedRaces = await getAllRaces();

    expect(receivedRaces).toEqual(expectedRaces);
  });

  it('Deve ser a raça correta quando buscar raça por id', async () => {
    const expectedRace = 
    {
      id: 8,
      name: 'Meio Elfo',
      baseLife: 5,
      baseStrength: 4,
      baseDamage: 6,
    };

    const receivedRace = await getRaceById(8);

    expect(receivedRace).toEqual(expectedRace);
  })
});
