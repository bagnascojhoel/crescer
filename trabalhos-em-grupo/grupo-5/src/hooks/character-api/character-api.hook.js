import { useAuthenticatedBaseAPI, API_CONTEXT } from '../';

export function useCharactersAPI() {
  const baseAPI = useAuthenticatedBaseAPI(API_CONTEXT.CHARACTERS);

  const getAllCharacters = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all characters: "${err}"`);
    }
  };

  const getCharactersByName = async (name) => {
    try {
      const { data } = await baseAPI.get(`/search/${name}`);
      return data;
    } catch (err) {
      console.error(`Error while trying to get characters by name: "${err}"`);
    }
  };

  return {
    getAllCharacters,
    getCharactersByName,
  };
}
