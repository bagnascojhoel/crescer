import './style.css';
import React from 'react';
import { Avatar, CardTitle } from '../';

export function CurrentCharacterCard({image, name}) {

  return (
    <div className="current-character">
      <Avatar url={image} size={100} />
      <CardTitle>{name}</CardTitle>
    </div>
  );
}
