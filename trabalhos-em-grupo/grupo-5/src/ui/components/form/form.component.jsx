import React from 'react';
import './style.css';

export function Form({ onSubmit, children, className, style }) {
  const _onSubmit = (event) => {
    event.preventDefault();
    onSubmit();
  };

  return (
    <form
      onSubmit={_onSubmit}
      className={className}
      style={style}
      className="form"
    >
      {children}
    </form>
  );
}
