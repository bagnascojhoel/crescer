import './style.css';
import React, { createElement } from 'react';
import { Redirect } from 'react-router-dom';
import { ROUTES } from '../../../routes';

export function CardList({ items, of, keyExtractor, column, ...props }) {
  return (
    <ul className={`card-list ${column && 'card-list--column'}`}>
      {items ? (
        items.map((item) =>
          createElement(of, { ...item, ...props, key: keyExtractor(item) })
        )
      ) : (
        <Redirect to={ROUTES.USER_LOGIN} />
      )}
    </ul>
  );
}
