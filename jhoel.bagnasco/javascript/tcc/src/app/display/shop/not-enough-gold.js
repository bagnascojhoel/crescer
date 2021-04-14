import { useQuestionInMenu } from '../../../services';

export const showNotEnoughGold = async () => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você não tem dinheiro suficiente
  para comprar este item

==================================

  { 0-9 } : voltar ao menu

  `);

  } catch (error) {
    console.error(`Error while trying to show not enough gold menu: "${error}"`);
  }
};
