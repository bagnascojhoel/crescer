import createGlobalState from 'react-create-global-state';

const [useGlobalCharacter, CharacterProvider] = createGlobalState(null);

export { useGlobalCharacter, CharacterProvider };
