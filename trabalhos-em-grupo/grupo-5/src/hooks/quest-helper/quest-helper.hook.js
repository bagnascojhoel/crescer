import { useQuestAPI } from '../';
import { useGlobalCharacter } from '../../context';
import { useCharacterHelper } from '../character-helper/character-helper.hook';
import { useUserMeAPI } from '../user-me-api/user-me-api.hook';

export function useQuestHelper() {
  const questAPI = useQuestAPI();
  const userAPI = useUserMeAPI();
  const characterHelper = useCharacterHelper();
  const [character] = useGlobalCharacter();
  const { questInProgress, busy } = character ?? {};

  const calculateEndTime = (duration) => Date.now() + parseInt(duration);

  const startQuest = async (questID, duration, description) => {
    if (questInProgress) return;
    if (busy) await questAPI.finishQuest(character.id);

    await questAPI.startQuest(character.id, questID);

    const newCharacter = await userAPI.getMyCharacterByID(character.id);

    characterHelper.select(newCharacter);
  };

  return {
    calculateEndTime,
    startQuest,
  };
}
