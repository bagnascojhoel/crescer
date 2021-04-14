import { useEffect } from 'react';
import { useLocalStorage } from '../';
import { useGlobalWatchlist } from '../../context';

export const useWatchlist = () => {
  const [watchlist, setWatchlist] = useGlobalWatchlist();
  const [watchlistStore, setWatchlistStore] = useLocalStorage(
    'WATCHLIST_STORE',
    []
  );

  useEffect(() => {
    setWatchlist(watchlistStore);
  }, []);

  useEffect(() => {
    setWatchlistStore(watchlist);
  }, [watchlist]);

  return [[...watchlist], setWatchlist];
};
