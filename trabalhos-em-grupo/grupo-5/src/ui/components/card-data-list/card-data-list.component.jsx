import React from 'react';
import './style.css';

function ListItem({ item }) {
  return <li className="card-data-list__item">{item}</li>;
}

export function CardDataList({ items }) {
  return (
    <ul className="card-data-list">
      {items.map((item, i) => (
        <ListItem key={i} item={item} />
      ))}
    </ul>
  );
}
