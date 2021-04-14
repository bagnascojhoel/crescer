import { useGlobalUser, USER_STORE_KEY } from '../../context';
import { useAuthAPI } from '../../hooks';

export function useLoginHelper() {
  const [globalUser, setGlobalUser] = useGlobalUser();
  const authAPI = useAuthAPI();

  const login = async (username, password) => {
    const { token } = await authAPI.login(username, password);
    const data = { username, token };
    
    setGlobalUser(data);
    localStorage.setItem(USER_STORE_KEY, JSON.stringify(data));
  };

  const logout = () => {
    setGlobalUser(null);
    localStorage.setItem(USER_STORE_KEY, null);
  };

  const getLogged = () => globalUser;

  return {
    login,
    logout,
    getLogged,
  };
}
