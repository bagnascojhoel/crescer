import React from 'react';
import './style.css';
import { ROUTES } from '../../../routes';
import { OnGoingQuestCard, GoBackButton, CurrentCharacterCard } from '../';
import { ButtonContainer } from '../button-container/button-container.component';
import { useGlobalCharacter } from '../../../context';

const defaultProps = {
  to: ROUTES.DASHBOARD,
};

export function Header({ title, buttonName, to, onClick, replace }) {
  const [character] = useGlobalCharacter();

  return (
    <div className="header-container">
      <GoBackButton />
      <h1 className="screen-title">{title}</h1>
      <div>
        <OnGoingQuestCard />
        {character && (
          <CurrentCharacterCard
            name={character.name}
            image={character.race.image}
          />
        )}

        <ButtonContainer
          link={!!to}
          to={to}
          onClick={onClick}
          hidden={!buttonName}
          replace={replace}
        >
          {buttonName}
        </ButtonContainer>
      </div>
    </div>
  );
}

Header.defaultProps = defaultProps;
