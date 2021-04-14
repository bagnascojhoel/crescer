import {
  QUEST_DETAILS_OPTIONS,
  showCannotStartQuest,
  showQuestDetails,
  showQuestList,
} from './display/tavern';

import { startQuest, onQuest } from '../';

export const handleTavern = async (character) => {
  let quest;
  while (!quest) {
    
    const pendingQuest = await showQuestList();
    const nextStep = await showQuestDetails(pendingQuest);

    if (nextStep === QUEST_DETAILS_OPTIONS.START_QUEST) quest = pendingQuest;
    else if (nextStep === QUEST_DETAILS_OPTIONS.GO_BACK_TO_MENU) return character;
  }

  if (!onQuest(character)) return startQuest(character, quest);
  else {
    await showCannotStartQuest();
    return character;
  }
};
