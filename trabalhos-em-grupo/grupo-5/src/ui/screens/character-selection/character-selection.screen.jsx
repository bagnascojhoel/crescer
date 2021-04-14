import React, { useEffect, useState } from 'react';
import { useUserMeAPI, useCharacterHelper } from '../../../hooks';
import { CharacterCard, CardList, Header } from '../../components';
import { ROUTES } from '../../../routes';
import { useGlobalCharacter } from '../../../context';

export function CharacterSelectionScreen() {
  const userMeAPI = useUserMeAPI();
  const characterSelection = useCharacterHelper();
  const [characters, setCharacters] = useState([]);

  useEffect(() => {
    async function getCharacters() {
      const characters = await userMeAPI.getMyCharacters();
      setCharacters(characters);
    }

    getCharacters();

    characterSelection.select(null);
  }, []);

  const handleCharacterSelection = characterSelection.select;

  return (
    <>
      <div className="container">
        <Header
          title="Selecione seu personagem"
          buttonName="Criar personagem"
          to={ROUTES.CHARACTER_REGISTER}
        />
        <div className="characters-container">
          <CardList
            items={characters}
            keyExtractor={({ id }) => id}
            of={CharacterCard}
            onSelectCharacter={handleCharacterSelection}
          ></CardList>
        </div>
      </div>
    </>
  );
}
