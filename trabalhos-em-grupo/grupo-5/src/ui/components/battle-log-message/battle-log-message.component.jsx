import React from 'react';
import './style.css';

function isCritical(prop) {
  if (prop) {
    return 'Sim';
  }
  return 'Não';
}

export function BattleLogMessage({ character, damage, critical }) {
  const { isOpponent, name } = character;
  return (
    <div
      className={`battle-log-message ${
        isOpponent && 'battle-log-message--opponent'
      }`}
    >
      <p>
        Turno de: <span>{name}</span>
      </p>
      <p>
        Dano causado: <span>{damage}</span>
      </p>
      <p>
        Crítico: <span>{isCritical(critical)}</span>
      </p>
    </div>
  );
}
