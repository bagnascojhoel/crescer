import { useQuestionInMenu } from '../../../services';

export const showCannotBattleWhileOnQuest = async () => {
  try {
    
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você não pode batalhar
  enquanto estiver fazendo uma
  missão!

==================================

  { 0-9 } : voltar ao menu
`);
  } catch (error) {
    console.error(`Error while trying to show cannot battle while on quest menu: "${error}"`);
  }
};
