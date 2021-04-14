import React from 'react';
import { Switch, Route, Redirect } from 'react-router-dom';
import './App.css';
import {
  UserLoginScreen,
  BattleLogScreen,
  BattleOpponentSelectionScreen,
  CharacterDetailsScreen,
  DashboardScreen,
  TavernScreen,
  ShopScreen,
  CharacterSelectionScreen,
  CharacterRegisterScreen,
} from './ui/screens';
import { ROUTES } from './routes';
import { useGlobalUser } from './context';

function PrivateRoute({ path, children }) {
  const [user] = useGlobalUser();

  if (!user) return <Redirect to={ROUTES.USER_LOGIN} />;

  return <Route path={path}>{children}</Route>;
}

function CharacterRouter() {
  return (
    <>
      <PrivateRoute path={ROUTES.CHARACTER} exact>
        <Redirect to={ROUTES.CHARACTER_SELECTION} />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.CHARACTER_REGISTER} exact>
        <CharacterRegisterScreen />
      </PrivateRoute>

      <PrivateRoute path={`${ROUTES.CHARACTER_DETAILS}/:characterID`} exact>
        <CharacterDetailsScreen />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.CHARACTER_SELECTION} exact>
        <CharacterSelectionScreen />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.DASHBOARD} exact>
        <DashboardScreen />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.SHOP} exact>
        <ShopScreen />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.TAVERN} exact>
        <TavernScreen />
      </PrivateRoute>

      <PrivateRoute path={`${ROUTES.BATTLE_LOG}/:opponentID/:opponentName`} exact>
        <BattleLogScreen />
      </PrivateRoute>

      <PrivateRoute path={ROUTES.BATTLE_OPPONENT_SELECTION} exact>
        <BattleOpponentSelectionScreen />
      </PrivateRoute>
    </>
  );
}

function App() {
  return (
    <>
      <Switch>
        <Route path="/" exact>
          <Redirect to={ROUTES.USER_LOGIN} />
        </Route>

        <Route path={ROUTES.USER_LOGIN}>
          <UserLoginScreen />
        </Route>

        <Route path={ROUTES.USER_REGISTER}></Route>

        <CharacterRouter />
      </Switch>
    </>
  );
}

export default App;
