import { useQuestionInMenu } from '../../../services';

export const showBattleResultVictory = async () => {
  try {
    
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Parabéns! Você venceu e subiu
  de nível!

==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(`Error while trying to show battle result victory menu: "${error}"`);
  }
};
