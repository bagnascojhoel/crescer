import React from 'react';
import './style.css';
import { Header, DashboardOptionCard } from '../../components';
import { RiFocus2Line, RiStore2Line, RiSwordLine } from 'react-icons/ri';
import { ROUTES } from '../../../routes';
import { useGlobalCharacter } from '../../../context';

export function DashboardScreen() {
  const [character] = useGlobalCharacter();
  const { busy } = character ?? {};

  return (
    <div className="container dashboard-screen">
      <Header title="Dashboard" />
      <div className="dashboard-screen__content">
        <DashboardOptionCard
          disabled={busy}
          to={ROUTES.BATTLE_OPPONENT_SELECTION}
          title="Batalhar"
          icon={RiSwordLine}
        />
        <DashboardOptionCard
          disabled={busy}
          to={ROUTES.TAVERN}
          title="Missões"
          icon={RiFocus2Line}
        />
        <DashboardOptionCard
          disabled={busy}
          to={ROUTES.SHOP}
          title="Loja"
          icon={RiStore2Line}
        />
      </div>
    </div>
  );
}
