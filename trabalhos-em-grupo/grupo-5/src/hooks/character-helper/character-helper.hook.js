import { useGlobalCharacter } from '../../context';

export function useCharacterHelper() {
  const [globalCharacter, setGlobalCharacter] = useGlobalCharacter();

  const select = (character) => {
    setGlobalCharacter(character);
  };

  const unselect = () => {
    setGlobalCharacter(null);
  };

  return {
    select,
    unselect,
  };
}
