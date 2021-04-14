import React from 'react';
import { Link } from 'react-router-dom';
import './style.css';

function Icon({ icon }) {
  return React.createElement(icon, {
    className: 'dashboard-option-card__icon',
    color: '#fff',
    size: 70,
  });
}

export function DashboardOptionCard({ to, title, icon, disabled }) {
  return (
    <Link
      to={to}
      onClick={(e) => {
        if (disabled) e.preventDefault();
      }}
      className="dashboard-option-card"
    >
      <h2 className="dashboard-option-card__title">{title}</h2>
      <Icon
        icon={icon}
        className="dashboard-option-card__icon"
        color="#fff"
        size={48}
      />
    </Link>
  );
}
