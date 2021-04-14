import { executeBattle, levelUpCharacter } from '../src';
describe('Suíte: batalha', () => {
  it('Deve ser nulo quando nenhum dos dois personagems puder causar dano ao outro', () => {
    const attackerCharacter = {
      race: {
        baseDamage: 3,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 1,
        baseLife: 15,
        baseStrength: 3,
      },
      items: [],
    };
    const expectedCharacter = null;

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O atacante deve subir um nível quando vencer', () => {
    const attackerCharacter = {
      level: 1,
      race: {
        baseDamage: 3,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };

    const defenderCharacter = {
      level: 1,
      race: {
        baseDamage: 1,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };
    const expectedCharacter = levelUpCharacter(attackerCharacter)

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O atacante deve vencer quando o defensor não puder lhe causar dano', () => {
    const attackerCharacter = {
      level: 1,
      race: {
        baseDamage: 3,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 1,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };
    const expectedCharacter = levelUpCharacter(attackerCharacter);

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O defensor deve vencer quando o atacante não puder lhe causar dano', () => {
    const attackerCharacter = {
      race: {
        baseDamage: 2,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 3,
        baseLife: 15,
        baseStrength: 2,
      },
      items: [],
    };
    const expectedCharacter = levelUpCharacter(defenderCharacter);

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O atacante deve vencer quando matar o defensor em dois ataques e aguentar um', () => {
    const attackerCharacter = {
      race: {
        baseDamage: 10,
        baseLife: 20,
        baseStrength: 0,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 10,
        baseLife: 10,
        baseStrength: 5,
      },
      items: [],
    };

    const expectedCharacter = levelUpCharacter(attackerCharacter);

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O atacante deve vencer quando matar o defensor em um ataque e morre em um', () => {
    const attackerCharacter = {
      race: {
        baseDamage: 15,
        baseLife: 5,
        baseStrength: 5,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 50,
        baseLife: 13,
        baseStrength: 2,
      },
      items: [],
    };

    const expectedCharacter = levelUpCharacter(attackerCharacter);

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });

  it('O defensor deve vencer quando sobreviver a um ataque e matar o atacante em um', () => {
    const attackerCharacter = {
      race: {
        baseDamage: 15,
        baseLife: 5,
        baseStrength: 5,
      },
      items: [],
    };

    const defenderCharacter = {
      race: {
        baseDamage: 50,
        baseLife: 14,
        baseStrength: 2,
      },
      items: [],
    };

    const expectedCharacter = levelUpCharacter(defenderCharacter);

    const receivedCharacter = executeBattle(
      attackerCharacter,
      defenderCharacter
    );

    expect(receivedCharacter).toEqual(expectedCharacter);
  });
});
