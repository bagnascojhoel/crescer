import { useQuestionInMenu } from '../../../services';

export const showCannotStartQuest = async () => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Você não pode fazer duas 
  missões ao mesmo tempo

==================================
  { 0-9 } : voltar ao menu

  `);

  } catch (error) {
    console.error(`Error while trying to show cannot start quest menu: "${error}"`);
  }
};
