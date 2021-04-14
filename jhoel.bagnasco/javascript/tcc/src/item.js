const ITEM_TYPE_MAP = {
  DAMAGE: 'DANO',
  LIFE: 'VIDA',
  STRENGTH: 'VIGOR',
};

export const measureLifeFromItems = ({ items }) =>
  items.reduce(
    (life, { type, enhancement }) =>
      type === ITEM_TYPE_MAP.LIFE ? life + enhancement : life,
    0
  );

export const measureStrengthFromItems = ({ items }) =>
  items.reduce(
    (strength, { type, enhancement }) =>
      type === ITEM_TYPE_MAP.STRENGTH ? strength + enhancement : strength,
    0
  );

export const measureDamageFromItems = ({ items }) =>
  items.reduce(
    (damage, { type, enhancement }) =>
      type === ITEM_TYPE_MAP.DAMAGE ? damage + enhancement : damage,
    0
  );
