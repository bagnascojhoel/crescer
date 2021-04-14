import { useQuestionInMenu } from '../../../services';

export const NAME_CONFIRMATION_OPTIONS = {
  CONFIRM: 1,
  CHANGE: 0,
  CANCEL: 9
}

export const showNameConfirmation = async (name) => {
  try {
    console.clear();
    return await useQuestionInMenu(`
  World of Warcraft
===================================

  Digite o número correspondente
  a ação que deseja tomar
  
===================================
  
  [ ${name} ]

===================================

  { ${NAME_CONFIRMATION_OPTIONS.CONFIRM} } : confirmar nome
  { ${NAME_CONFIRMATION_OPTIONS.CHANGE} } : mudar nome
  { ${NAME_CONFIRMATION_OPTIONS.CANCEL} } : cancelar criação
`)
  } catch (error) {
    console.error(
      `Error while trying to show the name confirmation menu: "${error}"`
    );
  }
}