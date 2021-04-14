import createGlobalState from 'react-create-global-state';

const [useGlobalWatchlist, WatchlistProvider] = createGlobalState([]);

export { useGlobalWatchlist, WatchlistProvider };
