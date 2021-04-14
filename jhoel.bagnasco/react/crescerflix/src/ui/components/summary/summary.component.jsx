import React from 'react';
import './styles.css';

const defaultProps = {
  children: ''
};

export const Summary = ({ children, maxWidth }) => {
  return (
    <p className="summary" style={{ maxWidth }}>
      {children}
    </p>
  );
};

Summary.defaultProps = defaultProps;
