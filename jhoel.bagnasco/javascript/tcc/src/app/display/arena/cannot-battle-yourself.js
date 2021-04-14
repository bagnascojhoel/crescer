import { useQuestionInMenu } from '../../../services';

export const showCannotBattleYourself = async () => {
  try {
    
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você não pode batalhar
  consigo mesmo!

==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(`Error while trying to show cannot battle yourself menu: "${error}"`);
  }
};
