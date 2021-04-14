import axios from 'axios';

function contextExists(context) {
  const contextList = Object.values(API_CONTEXT);

  return contextList.some((c) => c === context);
}

export const API_CONTEXT = {
  AUTH: 'auth',
  RACES: 'races',
  SHOP: 'shop',
  QUESTS: 'quests',
  USER: 'user',
  USER_ME: 'user/me',
  CHARACTERS: 'characters',
};

export function useBaseAPI(context, headers) {
  if (context && !contextExists(context)) throw 'Esse contexto não existe.';

  const contextPath = context ? `/${context}` : '';
  const baseAPI = axios.create({
    baseURL: `http://ec2-18-230-126-169.sa-east-1.compute.amazonaws.com${contextPath}`,
    headers,
  });

  return baseAPI;
}
