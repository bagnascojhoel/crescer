import { useQuestionInMenu } from '../../../services';

export const showBattleResultDraw = async () => {
  try {
    
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Houve um empate!

==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(`Error while trying to show battle result draw menu: "${error}"`);
  }
};
