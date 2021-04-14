import React from 'react';
import { TvShowCard } from '../';
import { ROUTES } from '../../../routes';

const fixName = (name) => (name ? name.toLowerCase().split(' ').join('-') : '');

const defaultProps = {
  items: [],
};

export const TvShowCardList = ({ items }) => {
  if (items.length === 0)
    return (
      <>
        <TvShowCard loading />
        <TvShowCard loading />
        <TvShowCard loading />
        <TvShowCard loading />
      </>
    );
  else
    return items.map(({ id, name, image, rating }) => (
      <TvShowCard
        key={id}
        to={`${ROUTES.TV_SHOW_DETAILS}/${id}/${fixName(name)}`}
        title={name}
        thumbnail={image?.medium}
        rating={rating}
      />
    ));
};

TvShowCardList.defaultProps = defaultProps;
