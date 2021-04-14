import { levelUpCharacter } from './character';

export const onQuest = (character) => {
  const { quest } = character;
  const questEnd = quest?.endDate;
  const isStillGoing = new Date().getTime() < new Date(questEnd).getTime();

  return quest && isStillGoing;
};

export const startQuest = (character, quest) => {
  if (onQuest(character)) return character;

  const endDate = new Date(Date.now() + quest.estimatedTime);

  return {
    ...character,
    quest: {
      ...quest,
      endDate,
    },
  };
};

export const endQuest = (character) => {
  if (onQuest(character)) return character;
  if (!character.quest) return character;
  
  const { quest, gold } = character;
  const { receivedLevels, receivedGold } = quest;

  let leveledUpCharacter = character;
  for (let levels = receivedLevels; levels > 0; levels--)
    leveledUpCharacter = levelUpCharacter(leveledUpCharacter);

  return {
    ...leveledUpCharacter,
    quest: null,
    gold: (gold ?? 0) + receivedGold,
  };
};
