import { canBuyIt, createCharacter, hasItem, buyItem } from '../src';

describe('Suíte: loja', () => {
  let character;
  beforeEach(() => {
    character = createCharacter('Jonas', {});
  });

  it('Deve ser falso quando o personagem não tiver dinheiro suficiente para compra-lo', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
  
    const received = canBuyIt(character, item);

    expect(received).toBeFalsy();
  });

  it('Deve ser verdadeiro quando o personagem tiver dinheiro suficiente para compra-lo', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
    
    const characterWithGold = {...character, gold: 40};
    const received = canBuyIt(characterWithGold, item);

    expect(received).toBeTruthy();
  });

  it('Deve ser falso quando o personagem não possuir o item', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
  
    const received = hasItem(character, item);

    expect(received).toBeFalsy();

  });

  it('Deve ser verdadeiro quando o personagem possuir o item', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
  
    const characterWithItem = {...character, items: [item]}
    const received = hasItem(characterWithItem, item);

    expect(received).toBeTruthy();
  });

  it('Deve adicionar o item ao personagem quando ele tiver dinheiro suficiente e não o possuir', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
    const expectedItems = [item];

    const characterWithGold = {...character, gold: 40};
    const receivedCharacter = buyItem(characterWithGold, item);

    expect(receivedCharacter.items).toEqual(expectedItems);
  });

  it('Deve não adicionar um item quando o personagem já o possui', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
    const expectedItems = [item];

    const characterWithItem = {...character, gold: 40, items: [item]};
    const receivedCharacter = buyItem(characterWithItem, item);

    expect(receivedCharacter.items).toEqual(expectedItems);
  });

  it('Deve não adicionar o item quando não tiver dinheiro suficiente para compra-lo', () => {
    const item = {
      id: 1,
      name: 'Espada curta',
      type: 'DANO',
      price: 40,
      enhancement: 3,
    };
    const expectedItems = [];

    const receivedCharacter = buyItem(character, item);

    expect(receivedCharacter.items).toEqual(expectedItems);
  });
});
