import { useQuestionInMenu } from '../../services';

export const INITIAL_MENU_OPTIONS = {
  CREATE_CHARACTER: 1,
  PLAY_WITH_CHARACTER: 2,
  EXIT: 0,
};

export const showInitalMenu = async () => {
  try {
    console.clear();

    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  a ação que deseja tomar

==================================

  { ${INITIAL_MENU_OPTIONS.CREATE_CHARACTER} } : criar personagem
  { ${INITIAL_MENU_OPTIONS.PLAY_WITH_CHARACTER} } : jogar com personagem   
  { ${INITIAL_MENU_OPTIONS.EXIT} } : sair                   
`);
  } catch (error) {
    console.error(`Error while trying to show the initial menu: "${error}"`);
  }
};
