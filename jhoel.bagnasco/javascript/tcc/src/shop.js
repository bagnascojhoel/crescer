export const canBuyIt = (character, item) => {
  return character.gold >= item.price;
};

export const hasItem = (character, itemToCheck) => {
  return character.items.some(({id}) => id === itemToCheck.id);
};

export const buyItem = (character, item) => {
  const { items, gold } = character;

  if (!hasItem(character, item) && canBuyIt(character, item)) {
    return {
      ...character,
      items: [...items, item],
      gold: gold - item.price,
    };
  } else return character;
};
