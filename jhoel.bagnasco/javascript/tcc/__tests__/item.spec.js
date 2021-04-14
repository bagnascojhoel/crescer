import {
  measureLifeFromItems,
  measureDamageFromItems,
  measureStrengthFromItems,
} from '../src';

describe('Suíte: item', () => {
  let character;

  beforeEach(() => {
    const items = [
      {
        id: 3,
        name: 'Espada de Chessus',
        type: 'DANO',
        price: 2000,
        enhancement: 90,
      },
      {
        id: 4,
        name: 'Chicote do Tinhoso',
        type: 'DANO',
        price: 2000,
        enhancement: 90,
      },
      {
        id: 7,
        name: 'Talismã de Chessus',
        type: 'VIDA',
        price: 2000,
        enhancement: 90,
      },
      {
        id: 8,
        name: 'Talismã do Tinhoso',
        type: 'VIDA',
        price: 2000,
        enhancement: 90,
      },
      {
        id: 11,
        name: 'Bracelete de Chessus',
        type: 'VIGOR',
        price: 2000,
        enhancement: 90,
      },
      {
        id: 12,
        name: 'Bracelete do Tinhoso',
        type: 'VIGOR',
        price: 2000,
        enhancement: 90,
      },
    ];
    character = { items };
  });

  it('Deve ser o total de vida proveniente de itens', () => {
    const expectedLife = 180;

    const receivedLife = measureLifeFromItems(character);

    expect(receivedLife).toBe(expectedLife);
  });

  it('Deve ser o total de vigor proveniente de itens', () => {
    const expectedStrength = 180;

    const receivedStrength = measureStrengthFromItems(character);

    expect(receivedStrength).toBe(expectedStrength);
  });

  it('Deve ser o total de dano proveniente de itens', () => {
    const expectedDamage = 180;

    const receivedDamage = measureDamageFromItems(character);

    expect(receivedDamage).toBe(expectedDamage);
  });
});
