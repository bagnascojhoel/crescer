import {
  RACE_STATUS_OPTIONS,
  NAME_CONFIRMATION_OPTIONS,
  showRaceList,
  showRaceStatus,
  showNameInput,
  showNameConfirmation,
} from './display';
import { saveCharacter } from '../services';
import { createCharacter } from '../character';

export const handleCharacterCreation = async () => {
  let name;
  let race;

  while (!race) {
    const pendingRace = await showRaceList();
    const nextStep = await showRaceStatus(pendingRace);

    if (nextStep === RACE_STATUS_OPTIONS.SELECT) race = pendingRace;
    else if (nextStep === RACE_STATUS_OPTIONS.GO_BACK_TO_MENU) return;
  }

  while (!name) {
    const chosenName = await showNameInput();
    const nextStep = await showNameConfirmation(chosenName);

    if (nextStep === NAME_CONFIRMATION_OPTIONS.CONFIRM) name = chosenName;
    else if (nextStep === NAME_CONFIRMATION_OPTIONS.CANCEL) return;
  }

  const character = createCharacter(name, race);

  saveCharacter(character);
};
