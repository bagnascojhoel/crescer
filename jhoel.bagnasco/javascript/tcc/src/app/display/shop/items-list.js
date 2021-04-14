import { getAllItems, useQuestionInMenu } from '../../../services';

const reducer = (acc, { name }, i) => acc + `  { ${i} } : ${name} \n`;

export const showItemsList = async () => {
  try {
    const items = await getAllItems();
    const itemsReduced = items.reduce(reducer, '');

    console.clear();
    const selectedIndex = await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  ao item com que deseja
  comprar

==================================

${itemsReduced}
`);

    return items[selectedIndex];
  } catch (error) {
    console.error(`Error while trying to show items list menu: "${error}"`);
  }
};
