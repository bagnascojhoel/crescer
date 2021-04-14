import React from 'react';
import './styles.css'

export const DogAvatarButtonAdd = ({ onAdd, children }) => {
  return (
    <button onClick={onAdd} className="dog-avatar-button-add button-shadow">
      {children}
      <svg
        className="dog-avatar-button-add__icon"
        xmlns="http://www.w3.org/2000/svg"
        viewBox="0 0 24 24"
      >
        <path d="M0 0h24v24H0z" fill="none" />
        <path d="M19 13h-6v6h-2v-6H5v-2h6V5h2v6h6v2z" />
      </svg>
    </button>
  );
};
