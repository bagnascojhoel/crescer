import { useQuestionInMenu } from '../../../services';

export const RACE_STATUS_OPTIONS = {
  SELECT: 1,
  GO_BACK_TO_LIST: 0,
  GO_BACK_TO_MENU: 9,
};

export const showRaceStatus = async ({ baseDamage, baseLife, baseStrength, name }) => {
  try {

    console.clear();

    return await useQuestionInMenu(`
  World of Warcraft
===================================

  Digite o número correspondente
  a ação que deseja tomar

===================================

  [ ${name} 

  [ DANO  : ${baseDamage}
  [ VIDA  : ${baseLife}
  [ VIGOR : ${baseStrength}

===================================

  { ${RACE_STATUS_OPTIONS.SELECT} } : selecionar esta raça
  { ${RACE_STATUS_OPTIONS.GO_BACK_TO_LIST} } : voltar à lista
  { ${RACE_STATUS_OPTIONS.GO_BACK_TO_MENU} } : voltar ao menu

`);
  } catch (error) {
    console.error(`Error while trying to show race status: "${error}"`);
  }
};
