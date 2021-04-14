import React from 'react';
import './style.css';
import { ROUTES } from '../../../routes';
import { ButtonContainer } from '../';

const defaultProps = {
  onSelectCharacter: () => {},
};

export function CharacterCard({
  id,
  name,
  race,
  level,
  money,
  faction,
  busy,
  items,
  kills,
  deaths,
  opponent,
  questInProgress,
  onSelectCharacter,
}) {
  const onClick = () => {
    onSelectCharacter({
      name,
      id,
      race,
      level,
      money,
      faction,
      items,
      busy,
      questInProgress,
    });
  };

  return (
    <div
      className={`card ${busy && 'card--busy'} ${
        faction === 'Horda' && 'card--horde'
      } ${opponent && busy ? 'card--no-actions' : ''}`}
    >
      <div className="character-card__content">
        <div className="character-card__avatar">
          <img src={`${race.image}`} />
        </div>

        <div className="character-card__infos">
          <h2>{name}</h2>
          <div className="character-card__details">
            <div>
              <h4>Raça: {race.name}</h4>
              <h4>Nível: {level}</h4>
            </div>

            <div>
              {opponent ? (
                <h4>Abates: {kills}</h4>
              ) : (
                <h4>Status: {busy ? 'Ocupado' : 'Disponível'}</h4>
              )}

              {opponent ? <h4>Mortes: {deaths}</h4> : <h4>$: {money}</h4>}
            </div>
          </div>
        </div>
      </div>

      <div className="character-card__action-buttons">
        <ButtonContainer
          secondary
          link
          hidden={!!opponent}
          to={ROUTES.CHARACTER_DETAILS + `/${id}`}
        >
          Detalhes
        </ButtonContainer>

        <ButtonContainer
          link
          to={
            opponent ? `${ROUTES.BATTLE_LOG}/${id}/${name}` : ROUTES.DASHBOARD
          }
          onClick={onClick}
          width={opponent && '100%'}
        >
          {opponent ? 'Selecionar oponente' : 'Jogar'}
        </ButtonContainer>
      </div>
    </div>
  );
}

CharacterCard.defaultProps = defaultProps;
