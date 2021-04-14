import { useQuestionInMenu } from '../../../services';

export const ITEM_STATUS_OPTIONS = {
  CONFIRM_BUY: 1,
  GO_BACK_TO_LIST: 0,
  GO_BACK_TO_MENU: 9,
};

export const showItemStatus = async ({ name, type, price, enhancement }) => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  a ação que deseja tomar

==================================

  [ ${name}

  [ TIPO:          ${type}
  [ PREÇO:         ${price}
  [ APRIMORAMENTO: ${enhancement}

==================================
  
  { ${ITEM_STATUS_OPTIONS.CONFIRM_BUY} } : confirmar compra
  { ${ITEM_STATUS_OPTIONS.GO_BACK_TO_LIST} } : voltar à lista
  { ${ITEM_STATUS_OPTIONS.GO_BACK_TO_MENU} } : voltar ao menu

`);
  } catch (error) {
    console.error(`Error while trying to show item status menu: "${error}"`);
  }
};
