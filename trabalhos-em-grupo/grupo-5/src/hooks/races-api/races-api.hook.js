import { useAuthenticatedBaseAPI, API_CONTEXT } from '../';

export function useRacesAPI() {
  const baseAPI = useAuthenticatedBaseAPI(API_CONTEXT.RACES);

  const getAllRaces = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all races: "${err}"`);
    }
  };

  return {
    getAllRaces,
  };
}
