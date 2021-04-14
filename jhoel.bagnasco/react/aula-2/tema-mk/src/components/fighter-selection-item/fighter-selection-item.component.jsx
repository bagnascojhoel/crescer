import React from 'react';
import './styles.css';

export function FighterSelectionItem({
  id,
  portraitImage,
  selected,
  onSelection,
}) {
  const handleClick = () => {
    if (!selected) onSelection(id);
  };

  return (
    <button onClick={handleClick} className={['fighter-selection-item']}>
      <img
        className={`fighter-selection-item__image ${
          selected && 'fighter-selection-item__image--selected'
        }`}
        src={portraitImage}
      />
    </button>
  );
}
