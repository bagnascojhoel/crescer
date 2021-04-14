import { useQuestionInMenu } from '../../../services';

export const QUEST_DETAILS_OPTIONS = {
  START_QUEST: 1,
  GO_BACK_TO_LIST: 0,
  GO_BACK_TO_MENU: 9,
};

export const showQuestDetails = async ({
  description,
  estimatedTime,
  receivedLevels,
  receivedGold,
}) => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  a ação que deseja tomar

==================================

  [ ${description}

  [ TEMPO ESTIMADO: ${estimatedTime / 1000}s
  [ ŔECOMPENSAS
    - NÍVEIS:   ${receivedLevels}
    - DINHEIRO: ${receivedGold}

==================================
  
  { ${QUEST_DETAILS_OPTIONS.START_QUEST} } : iniciar missão
  { ${QUEST_DETAILS_OPTIONS.GO_BACK_TO_LIST} } : voltar à lista
  { ${QUEST_DETAILS_OPTIONS.GO_BACK_TO_MENU} } : voltar ao menu

`);
  } catch (error) {
    console.error(`Error while trying to show quest details menu: "${error}"`);
  }
};
