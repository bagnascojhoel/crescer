import { useLocalStorage } from '../';
const LOCAL_STORAGE_CHARACTERS_KEY = 'characters';

const getCharactersRemote = () => {
  const localStorage = useLocalStorage();
  const charactersObject = localStorage.getObject(LOCAL_STORAGE_CHARACTERS_KEY)
  return charactersObject ?? {};
};

export const getCharacters = () => {
  const charactersObject = getCharactersRemote();

  return Object.values(charactersObject);
}

export const saveCharacter = (character) => {
  const localStorage = useLocalStorage();
  const characters = { ...getCharactersRemote(), [character.name]: character };

  localStorage.setObject(LOCAL_STORAGE_CHARACTERS_KEY, characters);
};

export const getCharacterByName = (characterName) => {
  return getCharactersRemote()
    .values()
    .find(({ name }) => name == characterName);
};
