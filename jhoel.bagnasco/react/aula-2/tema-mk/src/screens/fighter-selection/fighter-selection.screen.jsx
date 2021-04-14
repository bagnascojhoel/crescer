import React, { useState } from 'react';
import { FighterSelectionItem, FighterDetails } from '../../components';
import fighters from '../../fighters.json';
import './styles.css';

const getFighterById = (fighterId) =>
  fighters.find(({ id }) => id === fighterId);

export function FighterSelectionScreen() {
  const [playerOneFighter, setPlayerOneFighter] = useState(null);
  const [playerTwoFighter, setPlayerTwoFighter] = useState(null);

  const handlePlayerOneRemove = () => {
    setPlayerOneFighter(null);
  };

  const handlePlayerTwoRemove = () => {
    setPlayerTwoFighter(null);
  };

  const handleSelection = (id) => {
    const fighter = getFighterById(id);

    if (!playerOneFighter) setPlayerOneFighter(fighter);
    else if (!playerTwoFighter) setPlayerTwoFighter(fighter);
  };

  const fightersList = fighters.map(({ imagemListagem, id }) => (
    <FighterSelectionItem
      portraitImage={imagemListagem}
      onSelection={handleSelection}
      selected={
        playerOneFighter?.id === id ||
        playerTwoFighter?.id === id ||
        (playerOneFighter && playerTwoFighter)
      }
      id={id}
      key={id}
    />
  ));

  return (
    <div className="fighter-selection">
      <FighterDetails
        onRemove={handlePlayerOneRemove}
        fighterImage={playerOneFighter?.imagemDetalhe}
        name={playerOneFighter?.nome}
      />
      <div className="fighter-selection__list">{fightersList}</div>
      <FighterDetails
        onRemove={handlePlayerTwoRemove}
        fighterImage={playerTwoFighter?.imagemDetalhe}
        name={playerTwoFighter?.nome}
      />
    </div>
  );
}
