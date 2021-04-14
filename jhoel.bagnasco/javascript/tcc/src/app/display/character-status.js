import {
  measureTotalDamage,
  measureTotalLife,
  measureTotalStrength,
} from '../../character';
import { onQuest } from '../../quest';
import { useQuestionInMenu } from '../../services';

const reducer = (acc, { name, type, price }) => {
  return (
    acc +
    `
  # ${name}
    # ${type}
    # ${price}\n`
  );
};

const measureTimeLeft = ({ quest }) => {
  const endTime = new Date(quest.endDate).getTime();
  const now = Date.now();
  return endTime > now ? (endTime - now) / 1000 : 0;
};

export const showCharacterStatus = async (character) => {
  try {
    const { name, race, level, items, gold } = character;
    const reducedItems = items.reduce(reducer, '');

    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  [ ${name}
  [ ${race.name}

  [ LEVEL: ${level}
  [ DINHEIRO: ${gold}

  [ VIDA: ${measureTotalLife(character)}
  [ VIGOR: ${measureTotalStrength(character)}
  [ DANO: ${measureTotalDamage(character)}

  ${
    onQuest(character)
      ? `
  [ MISSÃO EM ANDAMENTO: ${character.quest.description}
    # TEMPO RESTANTE: ${Math.floor(measureTimeLeft(character))}s`
      : ''
  }

  [ ITENS
${reducedItems}
    
==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(
      `Error while trying to show character status menu: "${error}"`
    );
  }
};
