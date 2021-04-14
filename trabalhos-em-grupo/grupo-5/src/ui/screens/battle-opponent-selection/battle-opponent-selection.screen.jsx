import React, { useState, useEffect } from 'react';
import './style.css';
import { useCharactersAPI } from '../../../hooks';
import { Link, useHistory } from 'react-router-dom';
import { CardList, Header, CharacterCard } from '../../components';

function OpponentsList({ characters }) {
  return (
    <CardList
      items={characters}
      of={CharacterCard}
      keyExtractor={({ id }) => id}
      opponent
    ></CardList>
  );
}

export function BattleOpponentSelectionScreen() {
  const history = useHistory();
  const userMeAPI = useCharactersAPI();
  const [characters, setCharacters] = useState([]);

  useEffect(() => {
    async function getCharacters() {
      const characters = await userMeAPI.getAllCharacters();
      setCharacters(characters);
    }

    getCharacters();
  }, []);

  return (
    <>
      <div className="container">
        <Header title="Selecione seu oponente" />
        <div className="characters-container">
          <OpponentsList characters={characters} />
        </div>
      </div>
    </>
  );
}
