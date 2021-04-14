import React from 'react';
import { OverlayBox } from '../overlay-box';
import { Avatar } from '../avatar';
import './styles.css';

export function HeroCard({
  backgroundImage,
  backgroundColor,
  avatarImage,
  name,
  description,
}) {
  const BOX_WIDTH = 400;
  const AVATAR_WIDTH = 100;

  return (
    <OverlayBox
      backgroundImage={backgroundImage}
      overlayColor={backgroundColor}
      width={BOX_WIDTH}
    >
      <div className="hero-card__content">
        <Avatar imageUrl={avatarImage} side={AVATAR_WIDTH} />
        <div className="hero-card__text-content">
          <h1 className="hero-card__title">{name}</h1>
          <p className="hero-card__subtitle">{description}</p>
        </div>
      </div>
    </OverlayBox>
  );
}

HeroCard.defaultProps = {
  name: 'Heróis',
  description: 'Nós temos o Hulk',
  backgroundColor: 'black',
  avatarImage:
    'https://cdn1.iconfinder.com/data/icons/avengers-1/512/avangers_icon003-512.png',
  backgroundImage:
    'https://uploads.jovemnerd.com.br/wp-content/uploads/2020/09/marvels-avengers-review.jpg.webp',
};
