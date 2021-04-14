import React from 'react';
import './style.css';
import { Button, LinkButton } from '../';

export function ButtonContainer({ link, width, hidden, ...props }) {
  return (
    <div
      className="button-container"
      style={{ width, display: hidden && 'none' }}
    >
      {!link ? <Button {...props} /> : <LinkButton {...props} />}
    </div>
  );
}
