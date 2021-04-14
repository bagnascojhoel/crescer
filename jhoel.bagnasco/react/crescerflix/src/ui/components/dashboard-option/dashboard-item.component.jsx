import React from 'react';
import './styles.css'

import { Link } from 'react-router-dom';

export const DashboardOption = ({ to, children }) => {
  return (
    <Link to={to} className="dashboard-option">
      <h1 className="dashboard-option__text">{children}</h1>
    </Link>
  );
};
