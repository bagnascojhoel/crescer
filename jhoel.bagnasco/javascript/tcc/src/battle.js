import { levelUpCharacter } from './character';
import {
  measureTotalLife,
  measureTotalDamage,
  measureTotalStrength,
} from './character';

export const executeBattle = (attackerCharacter, defenderCharacter) => {
  let attacker = prepareForBattle(attackerCharacter);
  let defender = prepareForBattle(defenderCharacter);
  if (draw(attacker, defender)) return null;

  let winner;
  if (cannotCauseDamage(attacker, defender)) winner = defenderCharacter;
  else if (cannotCauseDamage(defender, attacker)) winner = attackerCharacter;
  else {
    let attackerTurn = true;

    while (isAlive(attacker) && isAlive(defender)) {
      if (attackerTurn) defender = causeDamage(attacker, defender);
      else attacker = causeDamage(defender, attacker);

      attackerTurn = !attackerTurn;
    }

    winner = isAlive(attacker) ? attackerCharacter : defenderCharacter;
  }

  return levelUpCharacter(winner);
};

const prepareForBattle = (character) => {
  const life = measureTotalLife(character);
  const strength = measureTotalStrength(character);
  const damage = measureTotalDamage(character);

  return {
    ...character,
    life,
    strength,
    damage,
  };
};

const cannotCauseDamage = (attacker, defender) =>
  attacker.damage <= defender.strength;

const draw = (attacker, defender) =>
  cannotCauseDamage(attacker, defender) &&
  cannotCauseDamage(defender, attacker);

const causeDamage = (attacker, target) => {
  if (attacker.damage <= target.strength) return target;

  const damage = attacker.damage - target.strength;

  return {
    ...target,
    life: target.life >= damage ? target.life - damage : 0,
  };
};

const isAlive = ({ life }) => life > 0;
