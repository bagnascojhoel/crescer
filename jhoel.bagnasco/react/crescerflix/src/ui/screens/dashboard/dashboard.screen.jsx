import React from 'react';

import { DashboardOption, Title } from '../../components';
import { ROUTES } from '../../../routes';

export const DashboardScreen = () => {
  return (
    <div className="container">
      <Title>Menu inicial</Title>
      <DashboardOption to={ROUTES.TV_SHOWS}>Séries</DashboardOption>
      <DashboardOption to={ROUTES.WATCHLIST}>Seus favoritos</DashboardOption>
    </div>
  );
};
