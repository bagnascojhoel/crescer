import React from 'react';
import './styles.css';
import { MdFavorite, MdFavoriteBorder } from 'react-icons/md';
// import { useGlobalWatchlist } from '../../../context';
import { useWatchlist } from '../../../hooks';
import { COLORS } from '../../colors';

const defaultProps = {
  size: 24,
  color: COLORS.GRAY,
};

export const WatchlistToggle = ({ tvShowId, size, color }) => {
  const [watchlist, setWatchlist] = useWatchlist();

  const isOnWatchlist = () => watchlist.some((id) => id === tvShowId);

  const handleClick = async () => {
    const newWatchlist = isOnWatchlist()
      ? watchlist.filter((id) => id !== tvShowId)
      : watchlist.concat(tvShowId);

    setWatchlist(newWatchlist);
  };

  return (
    <button onClick={handleClick} className="watchlist-toggle">
      {isOnWatchlist() ? (
        <MdFavorite color={color} size={size} />
      ) : (
        <MdFavoriteBorder color={color} size={size} />
      )}
    </button>
  );
};

WatchlistToggle.defaultProps = defaultProps;
