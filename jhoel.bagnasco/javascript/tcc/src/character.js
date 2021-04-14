import {
  measureDamageFromItems,
  measureStrengthFromItems,
  measureLifeFromItems,
} from './item';

const INITIAL_LEVEL = 1;
const updateStatus = (character) => {
  const { race, lifeBonus, strengthBonus } = character;
  const damage = race?.baseDamage ?? 0; // somar o dano dos itens
  const life = (race?.baseLife ?? 0) + (lifeBonus ?? 0); // somar a vida dos itens
  const strength = (race?.baseStrength ?? 0) + (strengthBonus ?? 0); // somar o vigor dos itens

  return {
    ...character,
    damage,
    life,
    strength,
  };
};

const updateBonus = (character) => {
  const LIFE_BONUS_UNIT = 2;
  const STRENGTH_BONUS_UNIT = 1;

  const lifeBonus = (character.lifeBonus ?? 0) + LIFE_BONUS_UNIT;
  const strengthBonus = (character.strengthBonus ?? 0) + STRENGTH_BONUS_UNIT;

  return {
    ...character,
    lifeBonus,
    strengthBonus,
  };
};

export const createCharacter = (name, race) => ({
  name,
  race,
  items: [],
  level: INITIAL_LEVEL,
});

export const levelUpCharacter = (character) => {
  const { level, bonusNextLevel } = character;
  const updatedCharacter = bonusNextLevel ? updateBonus(character) : character;

  return {
    ...updatedCharacter,
    level: (level ?? INITIAL_LEVEL) + 1,
    bonusNextLevel: !bonusNextLevel,
  };
};

export const measureTotalLife = (character) => {
  const { race, lifeBonus } = character;
  const { baseLife } = race;
  const lifeFromItems = measureLifeFromItems(character);

  return baseLife + (lifeBonus ?? 0) + lifeFromItems;
};

export const measureTotalStrength = (character) => {
  const { race, strengthBonus } = character;
  const { baseStrength } = race;
  const strengthFromItems = measureStrengthFromItems(character);

  return baseStrength + (strengthBonus ?? 0) + strengthFromItems;
};

export const measureTotalDamage = (character) => {
  const { race } = character;
  const { baseDamage } = race;
  const damageFromItems = measureDamageFromItems(character);

  return baseDamage + damageFromItems;
};
