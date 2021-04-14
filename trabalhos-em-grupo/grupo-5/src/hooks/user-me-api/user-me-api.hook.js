import { useAuthenticatedBaseAPI } from '../';
import { API_CONTEXT } from '../base-api/base-api.hook';

export function useUserMeAPI() {
  const userBaseAPI = useAuthenticatedBaseAPI(API_CONTEXT.USER);
  const userMeBaseAPI = useAuthenticatedBaseAPI(API_CONTEXT.USER_ME);

  const createCharacter = async (name, raceID, faction) => {
    try {
      const body = { name, raceId: raceID, faction };
      const response = await userBaseAPI.post('/create-character', body);
      return response;
    } catch (err) {
      console.error(`Error while trying to create character: "${err}`);
    }
  };

  const getMyself = async () => {
    try {
      const { data } = await userMeBaseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get logged user: "${err}"`);
    }
  };

  const getMyCharacters = async () => {
    try {
      const { data } = await userMeBaseAPI.get('/characters');
      return data;
    } catch (err) {
      console.error(
        `Error while trying to get logged user's characters: "${err}"`
      );
    }
  };

  const getMyCharacterByID = async (characterID) => {
    try {
      const { data } = await userMeBaseAPI.get(`/characters/${characterID}`);
      return data;
    } catch (err) {
      console.error(
        `Error while trying to get logged user's character by ID: "${err}"`
      );
    }
  };

  const deleteMyCharacter = async (characterID) => {
    try {
      const body = {};
      const response = await userMeBaseAPI.post(
        `/characters/${characterID}/delete`,
        body
      );
      return response;
    } catch (err) {
      console.error(
        `Error while trying to delete logged user's character: "${err}"`
      );
    }
  };

  const battleAgainst = async (characterID, opponentCharacterID) => {
    try {
      const body = { opponentId: opponentCharacterID };
      const { data } = await userMeBaseAPI.post(
        `/characters/${characterID}/battle`,
        body
      );
      return data;
    } catch (err) {
      console.error(`Error while trying to battle: "${err}"`);
    }
  };

  return {
    createCharacter,
    getMyself,
    getMyCharacters,
    getMyCharacterByID,
    deleteMyCharacter,
    battleAgainst,
  };
}