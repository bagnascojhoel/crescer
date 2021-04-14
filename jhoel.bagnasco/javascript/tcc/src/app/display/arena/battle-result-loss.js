import { useQuestionInMenu } from '../../../services';

export const showBattleResultLoss = async () => {
  try {
    
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você perdeu. Infelizmente, não
  foi dessa vez...

==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(`Error while trying to show battle result loss menu: "${error}"`);
  }
};
