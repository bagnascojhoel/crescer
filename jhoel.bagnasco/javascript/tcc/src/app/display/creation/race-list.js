import { getAllRaces, useQuestionInMenu } from '../../../services';

const reducer = (acc, { id, name }) => acc + `  { ${id} } : ${name} \n`;

export const showRaceList = async () => {
  try {
    const races = await getAllRaces();
    const racesReduced = races.reduce(reducer, '');

    console.clear();

    const selectedIndex = await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  a raça que deseja ler os
  status

==================================

${racesReduced}
`);

    return races[selectedIndex];
  } catch (error) {
    console.error(
      `Error while trying to show the race selection menu: "${error}"`
    );
  }
};
