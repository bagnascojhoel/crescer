import { getAllQuests, useQuestionInMenu } from '../../../services';

const reducer = (acc, { description }, i) => acc + `  { ${i} } : ${description} \n`;

export const showQuestList = async () => {
  try {
    const quests = await getAllQuests();
    const questsReduced = quests.reduce(reducer, '');

    console.clear();
    const selectedIndex = await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  à missão com que deseja iniciar

==================================

${questsReduced}
`);

    return quests[selectedIndex];
  } catch (error) {
    console.error(`Error while trying to show quests list menu: "${error}"`);
  }
};
