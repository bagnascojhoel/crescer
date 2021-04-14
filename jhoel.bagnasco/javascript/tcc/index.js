import {
  INITIAL_MENU_OPTIONS,
  showInitalMenu,
  handleCharacterCreation,
  handleCharacterSelection,
  handleGame,
} from './src/app';

const disconnect = async () => {
  console.clear();
  console.log(`
  ==============================================================================
                              Disconnecting...
  ==============================================================================
  `);
  await setTimeout(() => console.clear(), 2000);
};

const main = async () => {
  let exit = false;
  while (!exit) {
    console.clear();
    const selectedOption = await showInitalMenu();

    switch (selectedOption) {
      case INITIAL_MENU_OPTIONS.CREATE_CHARACTER:
        await handleCharacterCreation();

        break;
      case INITIAL_MENU_OPTIONS.PLAY_WITH_CHARACTER:
        const selectedCharacter = await handleCharacterSelection();
        await handleGame(selectedCharacter);
        break;
      case INITIAL_MENU_OPTIONS.EXIT:
        exit = true;
    }
  }

  await disconnect();
};

main();
