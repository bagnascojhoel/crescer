import { getCharacters, useQuestionInMenu } from '../../../services';

const reducer = (acc, { name }, i) => acc + `  { ${i} } : ${name} \n`;

export const showCharacterList = async () => {
  try {
    console.clear();
    
    const characters = await getCharacters();
    const charactersReduced = characters.reduce(reducer, '');

    const selectedOption = await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  ao personagem com que deseja
  jogar

==================================

${charactersReduced}
`);

    return characters[selectedOption];
  } catch (error) {
    console.error(`Error while trying to show character list menu: "${error}"`);
  }
};
