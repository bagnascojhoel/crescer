import React from 'react';
import './styles.css';

import { Link } from 'react-router-dom';
import { Rating, Thumbnail } from '../';

export const TvShowCard = ({ to, title, thumbnail, rating, loading }) => {
  return loading ? (
    <div className="tv-show-card tv-show-card--loading">
      <Thumbnail src={thumbnail} alt={title} />
    </div>
  ) : (
    <Link to={to} className="tv-show-card">
      <div className="tv-show-card__description">
        <Rating value={rating} iconSize={20} />
        <h1 className="tv-show-card__title">{title}</h1>
      </div>
      <Thumbnail src={thumbnail} alt={title} />
    </Link>
  );
};
