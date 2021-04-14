import React from 'react';

export function Avatar({ imageUrl, side }) {
  return (
    <div
      style={{
        backgroundSize: 'cover',
        backgroundPosition: 'center',
        backgroundImage: `url(${imageUrl})`,
        width: side,
        height: side,
      }}
    ></div>
  );
}
