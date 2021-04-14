import { useQuestionInMenu } from '../../../services';

export const showAlreadyBought = async () => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você já tem este item e não
  pode comprar outro igual

==================================

  { 0-9 } : voltar ao menu

  `);

  } catch (error) {
    console.error(`Error while trying to show already bought menu: "${error}"`);
  }
};
