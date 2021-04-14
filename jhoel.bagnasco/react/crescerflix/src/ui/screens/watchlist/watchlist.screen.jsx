import React, { useEffect, useState } from 'react';
import { useTvShowsAPI, useWatchlist } from '../../../hooks';
import { Title, TvShowCardList } from '../../components';

const API = useTvShowsAPI();
export const WatchlistScreen = () => {
  const [watchlist] = useWatchlist();
  const [pageItems, setPageItems] = useState([]);

  useEffect(() => {
    Promise.all(watchlist.map((id) => API.getTvShow(id))).then(
      (resolvedItems) => {
        setPageItems(resolvedItems);
      }
    );
  }, [watchlist]);

  return (
    <div className="container">
      <Title>Favoritos</Title>
      {watchlist.length > 0 ? (
        <TvShowCardList items={pageItems} />
      ) : (
        <p>Você não possui nenhum favorito ainda.</p>
      )}
    </div>
  );
};
