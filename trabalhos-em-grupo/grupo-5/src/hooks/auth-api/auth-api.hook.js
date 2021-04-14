import { useBaseAPI, API_CONTEXT } from '../';

const baseAPI = useBaseAPI(API_CONTEXT.AUTH);

export function useAuthAPI() {
  const login = async (username, password) => {
    try {
      const { data } = await baseAPI.post('/login', { username, password });
      return data;
    } catch (err) {
      console.error(`Error while trying to login: "${err}"`);
    }
  };

  return {
    login,
  };
}
