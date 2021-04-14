import { createCharacter, onQuest, startQuest, endQuest } from '../src';

describe('Suíte: missão', () => {
  let character;
  beforeEach(() => {
    character = createCharacter('Ohlihmpoh', {});
  });

  it('Deve ser falso quando personagem não estiver em uma missão', () => {
    const received = onQuest(character);

    expect(received).toBeFalsy();
  });

  it('Deve ser falso quando personagem estiver em uma missão que já acabou', () => {
    const quest = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 0,
      receivedLevels: 3,
      receivedGold: 70,
      endDate: new Date(),
    };
    const characterOnQuest = { ...character, quest };
    const received = onQuest(characterOnQuest);

    expect(received).toBeFalsy();
  });

  it('Deve ser verdadeiro quando personagem estiver em uma missão que ainda não acabou', () => {
    const quest = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 99999999999,
      receivedLevels: 3,
      receivedGold: 70,
      endDate: new Date(Date.now() + 99999999999),
    };
    const characterOnQuest = { ...character, quest };
    const received = onQuest(characterOnQuest);

    expect(received).toBeTruthy();
  });

  it('Deve receber SETENTA de dinheiro quando completar missão', () => {
    const quest = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 99999999999,
      receivedLevels: 3,
      receivedGold: 70,
      endDate: new Date(),
    };
    const characterOnQuest = { ...character, quest };
    const expectedGold = 70;

    const receivedCharacter = endQuest(characterOnQuest);

    expect(receivedCharacter.gold).toBe(expectedGold);
  });

  it('Deve receber TRÊS níveis quando completar missão', () => {
    const quest = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 99999999999,
      receivedLevels: 3,
      receivedGold: 70,
      endDate: new Date()
    };
    const characterOnQuest = { ...character, quest };
    const expectedLevel = character.level + 3;

    const receivedCharacter = endQuest(characterOnQuest);

    expect(receivedCharacter.level).toBe(expectedLevel);
  });

  it('Deve não mudar nada quando o personagem ainda está em missão', () => {
    const quest = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 99999999999,
      receivedLevels: 3,
      receivedGold: 70,
      endDate: new Date().getTime() + 99999999,
    };
    const characterOnQuest = { ...character, quest };
    const expectedCharacter = characterOnQuest;

    const receivedCharacter = endQuest(characterOnQuest);

    expect(receivedCharacter).toBe(expectedCharacter);
  });

  it('Deve ser o mesmo personagem quando tentar fazer missão enquanto já está fazendo alguma', () => {
    const quest1 = {
      id: 5,
      description: 'Defender uma cidade de ataques de Worgs',
      estimatedTime: 99999999999,
      receivedLevels: 3,
      receivedGold: 70,
    };
    const quest2 = {
      id: 7,
      description: 'Derrotar o Lich',
      estimatedTime: 300000,
      receivedLevels: 8,
      receivedGold: 170,
    };

    const characterOnQuest = startQuest(character, quest1);
    const expectedCharacter = characterOnQuest;

    const receivedCharacter = startQuest(characterOnQuest, quest2);

    expect(receivedCharacter).toEqual(expectedCharacter);
  });
});
