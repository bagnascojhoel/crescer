import { useQuestionInMenu } from '../services';

export const CHARACTER_ACTIONS_OPTIONS = {
  ARENA: 1,
  TAVERN: 2,
  SHOP: 3,
  CHARACTER_STATUS: 4,
  EXIT: 0,
};

export const handleCharacterActions = async () => {
  console.clear();
  return await useQuestionInMenu(`
  World of Warcraft
==================================

  Digite o número correspondente
  à ação que deseja tomar

==================================

  { ${CHARACTER_ACTIONS_OPTIONS.ARENA} } : arena
  { ${CHARACTER_ACTIONS_OPTIONS.TAVERN} } : taberna
  { ${CHARACTER_ACTIONS_OPTIONS.SHOP} } : loja
  { ${CHARACTER_ACTIONS_OPTIONS.CHARACTER_STATUS} } : status do personagem
  { ${CHARACTER_ACTIONS_OPTIONS.EXIT} } : voltar ao menu inicial
`);
};
