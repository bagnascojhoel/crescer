import createGlobalState from 'react-create-global-state';

const USER_STORE_KEY = 'user';

const stringifiedUser = localStorage.getItem(USER_STORE_KEY);

const initialUser = stringifiedUser ? JSON.parse(stringifiedUser) : null;

const [useGlobalUser, UserProvider] = createGlobalState(initialUser);

export { useGlobalUser, UserProvider, USER_STORE_KEY };
