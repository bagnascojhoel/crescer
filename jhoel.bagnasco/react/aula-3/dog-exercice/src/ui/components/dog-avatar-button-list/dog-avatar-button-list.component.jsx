import React from 'react';
import './styles.css';
import { DogAvatarButton } from '../index';

const AVATAR_DIAMETER = 210;

export const DogAvatarButtonList = ({ dogs, onRemove }) => {
  return (
    <div className="dog-avatar-button-list">
      {dogs.map(({ dogImage, id }) => (
        <DogAvatarButton
          key={id}
          onClick={() => onRemove(id)}
          diameter={AVATAR_DIAMETER}
          dogImage={dogImage}
        />
      ))}
    </div>
  );
};
