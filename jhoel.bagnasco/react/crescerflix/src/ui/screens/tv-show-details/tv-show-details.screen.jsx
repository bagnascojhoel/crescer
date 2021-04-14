import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useTvShowsAPI } from '../../../hooks';
import {
  GenreList,
  GoBackButton,
  Rating,
  Summary,
  Thumbnail,
  Title,
  WatchlistToggle,
} from '../../components';
import './styles.css';

const API = useTvShowsAPI();
export const TvShowDetailsScreen = () => {
  const params = useParams();
  const [{ rating, name, genres, image, summary }, setTvShow] = useState({});
  const id = parseInt(params.id);

  useEffect(() => {
    (async () => {
      const {
        rating,
        name,
        genres,
        officialSite,
        image,
        summary,
      } = await API.getTvShow(id);

      setTvShow({
        rating,
        name,
        genres,
        officialSite,
        image,
        summary,
      });
    })();
  }, [id]);

  return (
    <article className="container tv-show-details">
      <GoBackButton />
      <div className="row">
        <Thumbnail src={image?.original} alt={`${name}'s banner.`} large />

        <div className="column">
          <GenreList genres={genres} />

          <div className="row row--space-between">
            <div className="tv-show-details__title-container">
              <WatchlistToggle tvShowId={id} />
              <Title>{name}</Title>
            </div>
            <Rating value={rating} starSize={36} />
          </div>

          <Summary maxWidth="100%">{summary}</Summary>
        </div>
      </div>
    </article>
  );
};
