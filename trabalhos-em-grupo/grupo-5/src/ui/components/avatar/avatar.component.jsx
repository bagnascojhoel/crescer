import React from 'react';
import './style.css';

export function Avatar({ url, size, round }) {
  return (
    <div
      className={`avatar ${round && 'avatar--round'}`}
      style={{ backgroundImage: `url(${url})`, width: size, height: size }}
    ></div>
  );
}
