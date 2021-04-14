import React from 'react';
import './styles.css';

const Genre = ({ children }) => {
  return <span className="genre">{children}</span>;
};

const defaultProps = {
  genres: [],
};

export const GenreList = ({ genres }) => {
  return (
    <div className="genre-list">
      {genres.map((genre) => (
        <Genre key={genre}>{genre}</Genre>
      ))}
    </div>
  );
};

GenreList.defaultProps = defaultProps;
