import '@babel/polyfill';
import axios from 'axios';
import { getAllItems, getItemById } from '../../src/services';

jest.mock('axios');

describe('Suíte: repositório de item', () => {
  beforeEach(() => {
    const items = [
      {
        id: 1,
        nome: 'Espada curta',
        tipo: 'DANO',
        preco: 40,
        aprimoramento: 3,
      },
      {
        id: 2,
        nome: 'Espada longa',
        tipo: 'DANO',
        preco: 90,
        aprimoramento: 7,
      },
      {
        id: 3,
        nome: 'Espada de Chessus',
        tipo: 'DANO',
        preco: 2000,
        aprimoramento: 90,
      },
    ];
    const response = { data: items };

    axios.get.mockResolvedValue(response);
  });

  it('Deve ser todos itens quando pegar todos itens', async () => {
    const expectedItems = [
      {
        id: 1,
        name: 'Espada curta',
        type: 'DANO',
        price: 40,
        enhancement: 3,
      },
      {
        id: 2,
        name: 'Espada longa',
        type: 'DANO',
        price: 90,
        enhancement: 7,
      },
      {
        id: 3,
        name: 'Espada de Chessus',
        type: 'DANO',
        price: 2000,
        enhancement: 90,
      },
    ];

    const receivedItems = await getAllItems();

    expect(receivedItems).toEqual(expectedItems);
  });

  it('Deve ser o item correto quando pegar item por id', async () => {
    const expectedItem = {
      id: 2,
      name: 'Espada longa',
      type: 'DANO',
      price: 90,
      enhancement: 7,
    };

    const receivedItem = await getItemById(2);

    expect(receivedItem).toEqual(expectedItem);    
  });
});
