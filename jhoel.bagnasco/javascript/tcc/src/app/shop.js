import {
  ITEM_STATUS_OPTIONS,
  showAlreadyBought,
  showNotEnoughGold,
  showItemStatus,
  showItemsList,
} from './display/shop';
import { buyItem, hasItem } from '../../src';
export const handleShop = async (character) => {
  let item;

  while (!item) {
    const pendingItem = await showItemsList();
    const nextStep = await showItemStatus(pendingItem);

    if (nextStep === ITEM_STATUS_OPTIONS.CONFIRM_BUY) item = pendingItem;
    else if (nextStep === ITEM_STATUS_OPTIONS.GO_BACK_TO_MENU) return character;
  }

  if (!hasItem(character, item)) {
    const pendingBuyCharacter = buyItem(character, item);

    if (hasItem(pendingBuyCharacter, item)) return pendingBuyCharacter;
    else {
      await showNotEnoughGold();
      return character;
    }
  } else {
    await showAlreadyBought();
    return character;
  }
};
