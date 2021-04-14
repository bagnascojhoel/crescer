import React from 'react';
import { MdFavorite, MdHome, MdViewList } from 'react-icons/md';
import { Route, Switch } from 'react-router-dom';
import './App.css';
import { ROUTES } from './routes';
import { HeaderNavOption } from './ui/components';
import {
  DashboardScreen,
  NotFoundScreen,
  TvShowDetailsScreen,
  TvShowsScreen,
  WatchlistScreen,
} from './ui/screens';

function App() {
  return (
    <div className="App">
      <header>
        <nav>
          <HeaderNavOption to={ROUTES.HOME} icon={MdHome} />
          <HeaderNavOption to={ROUTES.TV_SHOWS} icon={MdViewList} />
          <HeaderNavOption to={ROUTES.WATCHLIST} icon={MdFavorite} />
        </nav>
      </header>
      <Switch>
        <Route path={ROUTES.HOME} exact>
          <DashboardScreen />
        </Route>

        <Route path={ROUTES.TV_SHOWS} exact>
          <TvShowsScreen />
        </Route>

        <Route path={ROUTES.WATCHLIST} exact>
          <WatchlistScreen />
        </Route>

        <Route path={`${ROUTES.TV_SHOW_DETAILS}/:id/:name`} exact>
          <TvShowDetailsScreen />
        </Route>

        <Route>
          <NotFoundScreen />
        </Route>
      </Switch>
    </div>
  );
}

export default App;
