import React from 'react';
import { Link, useLocation } from 'react-router-dom';
import { COLORS } from '../../colors';
import './styles.css';

const Icon = ({ icon, active }) =>
  React.createElement(icon, {
    className: 'header-nav-option__icon',
    color: active ? COLORS.SECONDARY : COLORS.GRAY,
    size: 30,
  });

export const HeaderNavOption = ({ to, icon }) => {
  const location = useLocation();

  const content =
    location.pathname !== to ? (
      <Icon icon={icon} />
    ) : (
      <Icon icon={icon} active />
    );

  return <Link to={to} className="header-nav-option">{content}</Link>;
};
