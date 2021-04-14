import {
  createCharacter,
  levelUpCharacter,
  measureTotalLife,
  measureTotalStrength,
  measureTotalDamage,
} from '../src';

describe('Suíte: criação de personagem', () => {
  it('Deve começar sem items', () => {
    const receivedCharacter = createCharacter('Jonas', {});

    expect(receivedCharacter.items?.length).toBe(0);
  });

  it('Deve ter nível igual ou maior a UM', () => {
    const expectedCharacter = createCharacter('Jonas', {});

    expect(expectedCharacter.level).toBeGreaterThanOrEqual(1);
  });
});

describe('Suíte: comportamento de personagem', () => {
  let character;

  beforeEach(() => {
    character = createCharacter('Totó', {});
  });

  it('Deve aumentar em UM o nível do personagem quando subir de nível', () => {
    const expectedLevel = character.level + 1;

    const receivedCharacter = levelUpCharacter(character);

    expect(receivedCharacter.level).toBe(expectedLevel);
  });

  it('Deve aumentar em DOIS a vida bônus do personagem quando subir dois níveis', () => {
    const expectedLife = (character.lifeBonus ?? 0) + 2;

    const firstLevel = levelUpCharacter(character);
    const receivedCharacter = levelUpCharacter(firstLevel);

    expect(receivedCharacter.lifeBonus).toBe(expectedLife);
  });

  it('Deve aumentar em UM o vigor bônus do personagem quando subir dois níveis', () => {
    const expectedStrength = (character.strengthBonus ?? 0) + 1;

    const firstLevel = levelUpCharacter(character);
    const receivedCharacter = levelUpCharacter(firstLevel);

    expect(receivedCharacter.strengthBonus).toBe(expectedStrength);
  });

  it('Deve somar a vida proveninete da raça, níveis e itens', () => {
    let buffedCharacter = {
      ...character,
      race: {
        id: 2,
        name: 'Anão',
        baseLife: 6,
        baseStrength: 5,
        baseDamage: 3,
      },
    };
    buffedCharacter = levelUpCharacter(buffedCharacter);
    buffedCharacter = levelUpCharacter(buffedCharacter);
    buffedCharacter = {
      ...buffedCharacter,
      items: [
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
      ],
    };
    const expectedLife = 6 + 2 + 180;

    const receivedLife = measureTotalLife(buffedCharacter);

    expect(receivedLife).toBe(expectedLife);
  });

  it('Deve somar o vigor proveninete da raça, níveis e itens', () => {
    let buffedCharacter = {
      ...character,
      race: {
        id: 2,
        name: 'Anão',
        baseLife: 6,
        baseStrength: 5,
        baseDamage: 3,
      },
    };
    buffedCharacter = levelUpCharacter(buffedCharacter);
    buffedCharacter = levelUpCharacter(buffedCharacter);
    buffedCharacter = {
      ...buffedCharacter,
      items: [
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
          type: 'VIGOR',
          price: 2000,
          enhancement: 90,
        },
      ],
    };
    const expectedStrength = 5 + 1 + 90;

    const receivedStrength = measureTotalStrength(buffedCharacter);

    expect(receivedStrength).toBe(expectedStrength);
  });

  it('Deve somar o dano proveninete da raça e itens', () => {
    let buffedCharacter = {
      ...character,
      race: {
        id: 2,
        name: 'Anão',
        baseLife: 6,
        baseStrength: 5,
        baseDamage: 3,
      },
    };
    buffedCharacter = {
      ...buffedCharacter,
      items: [
        {
          id: 7,
          name: 'Talismã de Chessus',
          type: 'DANO',
          price: 2000,
          enhancement: 90,
        },
        {
          id: 8,
          name: 'Talismã do Tinhoso',
          type: 'VIGOR',
          price: 2000,
          enhancement: 90,
        },
      ],
    };
    const expectedDamage = 3 + 90;

    const receivedDamage = measureTotalDamage(buffedCharacter);

    expect(receivedDamage).toBe(expectedDamage);
  });
});
