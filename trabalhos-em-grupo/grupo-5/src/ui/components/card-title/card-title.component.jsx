import React from 'react';
import './style.css'

export function CardTitle({ className, children }) {
  return <h2 className={`card-title ${className}`}>{children}</h2>;
}
