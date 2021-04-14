import React from 'react';
import { MdStar, MdStarBorder } from 'react-icons/md';
import { COLORS } from '../../colors';
import './styles.css';

const Star = ({ active, size, color }) => {
  return (
    <button className={`rating__star`}>
      {active ? (
        <MdStar color={color} size={size} />
      ) : (
        <MdStarBorder color={color} size={size} />
      )}
    </button>
  );
};

const defaultProps = {
  value: 0,
  iconColor: COLORS.GRAY,
  iconSize: 36,
};

const STARS_QTY = 5;

export const Rating = ({ value, iconSize, iconColor }) => {
  let stars = [];
  for (let i = 1; i <= STARS_QTY; i++)
    stars.push(
      <Star
        key={i}
        value={i}
        active={i <= value}
        size={iconSize}
        color={iconColor}
      />
    );

  return <div className="rating">{stars}</div>;
};

Rating.defaultProps = defaultProps;
