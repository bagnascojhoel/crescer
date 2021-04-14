import React from 'react';
import './style.css';

export function Button({ onClick, children, secondary, noGutter }) {
  return (
    <button
      className={`button ${secondary && 'button--secondary'} 
    ${noGutter && 'button--no-gutter'}`}
      onClick={onClick}
    >
      {children}
    </button>
  );
}
