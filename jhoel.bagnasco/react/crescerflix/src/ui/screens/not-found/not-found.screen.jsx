import React from 'react'
import {DashboardOption} from '../../components'
import {ROUTES} from '../../../routes';

export const NotFoundScreen = () => {
  return <div className="container not-found">
    <h1>Página não encontrada!</h1>
    <h2>Calma cupinxa, clica em alguma dessas aqui que elas sim existem:</h2>
    <DashboardOption to={ROUTES.HOME}>Menu Inicial</DashboardOption>
    <DashboardOption to={ROUTES.TV_SHOWS}>Séries</DashboardOption>
    <DashboardOption to={ROUTES.WATCHLIST}>Seus favoritos</DashboardOption>
  </div>
}