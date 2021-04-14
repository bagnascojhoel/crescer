import { API_CONTEXT, useAuthenticatedBaseAPI } from '../';

export function useQuestAPI() {
  const baseAPI = useAuthenticatedBaseAPI(API_CONTEXT.QUESTS);

  const getAllQuests = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all quests: ${err}`);
    }
  };

  const getQuestByID = async (questID) => {
    try {
      const { data } = await baseAPI.get(`/${questID}`);
      return data;
    } catch (err) {
      console.error(`Error while trying to get item by ID: ${err}`);
    }
  };

  const startQuest = async (characterID, questID) => {
    try {
      const body = { characterId: characterID };
      const { data } = await baseAPI.post(`/${questID}/start`, body);
      return data;
    } catch (err) {
      console.error(`Error while trying to start quest: ${err}`);
    }
  };

  const finishQuest = async (characterID) => {
    try {
      const body = { characterId: characterID };
      const { data } = await baseAPI.post(`/finish`, body);
      return data;
    } catch (err) {
      console.error(`Error while trying to finish quest: ${err}`);
    }
  };

  return {
    getAllQuests,
    getQuestByID,
    startQuest,
    finishQuest,
  };
}
