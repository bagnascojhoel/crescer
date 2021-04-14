import {
  handleCharacterActions,
  CHARACTER_ACTIONS_OPTIONS,
} from './character-actions';

import { saveCharacter } from '../services';

import { handleArena } from './arena';
import { handleTavern } from './tavern';
import { handleShop } from './shop';
import { endQuest, onQuest } from '../quest';
import { showCannotBattleWhileOnQuest } from './display/arena';
import { showCharacterStatus } from './display/character-status';

export const handleGame = async (characterRead) => {
  let character = characterRead;

  while (true) {
    const nextStep = await handleCharacterActions();
    character = endQuest(character);

    switch (nextStep) {
      case CHARACTER_ACTIONS_OPTIONS.ARENA:
        if (!onQuest(character)) {
          character = await handleArena(character);
        } else await showCannotBattleWhileOnQuest();
        break;
      case CHARACTER_ACTIONS_OPTIONS.TAVERN:
        character = await handleTavern(character);
        break;
      case CHARACTER_ACTIONS_OPTIONS.SHOP:
        character = await handleShop(character);
        break;
      case CHARACTER_ACTIONS_OPTIONS.CHARACTER_STATUS:
        await showCharacterStatus(character);
        break;
      case CHARACTER_ACTIONS_OPTIONS.EXIT:
        return;
    }

    saveCharacter(character);
  }
};
