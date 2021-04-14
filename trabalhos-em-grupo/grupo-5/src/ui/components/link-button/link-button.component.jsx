import React from 'react';
import './style.css';
import { Link } from 'react-router-dom';

export function LinkButton({ to, secondary, onClick, children }) {
  return (
    <Link
      to={to}
      onClick={onClick}
      className={`link-button ${secondary && 'link-button--secondary'}`}
    >
      {children}
    </Link>
  );
}
