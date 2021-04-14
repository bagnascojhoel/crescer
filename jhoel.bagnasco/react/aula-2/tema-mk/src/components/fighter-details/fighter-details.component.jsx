import React from 'react';
import './styles.css';

const defaultProps = {
  onRemove: () => {},
  fighterImage:
    'https://vignette.wikia.nocookie.net/mkwikia/images/1/17/Noobmk2.gif/revision/latest?cb=20090209150623',
  name: 'Unknown',
};

export function FighterDetails({ onRemove, fighterImage, name }) {
  return (
    <div
      className={`fighter-details ${
        name === defaultProps.name && 'fighter-details--disabled'
      }`}
    >
      <h1 className="fighter-details__name">{name}</h1>
      <img
        className="fighter-details__image"
        src={fighterImage}
        alt={`Imagem do ${name}`}
      />
      <button onClick={onRemove} className="fighter-details__remove-button">
        Remover
      </button>
    </div>
  );
}

FighterDetails.defaultProps = defaultProps;
