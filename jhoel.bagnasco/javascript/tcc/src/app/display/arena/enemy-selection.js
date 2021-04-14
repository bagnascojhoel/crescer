import { useQuestionInMenu, getCharacters } from '../../../services';

const reducer = (acc, { name }, i) => acc + `  { ${i} } : ${name} \n`;

export const showEnemySelection = async () => {
  try {
    const characters = await getCharacters();
    const reducedCharacter = characters.reduce(reducer, '');

    console.clear();

    const selectedIndex = await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  ao personagem com quem
  deseja batalhar

==================================

${reducedCharacter}
`);

    return characters[selectedIndex];
  } catch (error) {
    console.error(`Error while trying to show enemy selection menu: "${error}"`);
  }
};
