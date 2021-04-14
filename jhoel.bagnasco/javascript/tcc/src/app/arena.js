import {
  showEnemySelection,
  showCannotBattleYourself,
  showBattleResultDraw,
  showBattleResultLoss,
  showBattleResultVictory,
} from './display/arena';
import { executeBattle } from '../';
import { randomNumber } from '../services';

export const handleArena = async (character) => {
  const enemy = await showEnemySelection();

  if (enemy.name === character.name) {
    await showCannotBattleYourself();
    return character;
  }

  const characterAttack = randomNumber(1, 4) > 2;
  const attackerCharacter = characterAttack ? character : enemy;
  const defenderCharacter = characterAttack ? enemy : character;

  const battleResult = executeBattle(attackerCharacter, defenderCharacter);

  if (battleResult?.name === character.name) {
    await showBattleResultVictory();

    return battleResult;
  } else if (battleResult === null) await showBattleResultDraw();
  else if (battleResult.name !== character.name) await showBattleResultLoss();

  return character;
};
