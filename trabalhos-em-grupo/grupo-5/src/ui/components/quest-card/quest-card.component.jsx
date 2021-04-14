import React from 'react';
import './style.css';
import { Avatar, CardTitle, CardDataList } from '../';
import { displayTime } from '../../../utils';

const defaultProps = {
  duration: 0,
  experience: 0,
  money: 0,
  description: 'Missão',
  onClick: () => {},
};

export function QuestCard({
  onClick,
  id,
  description,
  duration,
  experience,
  money,
  image,
  disabled,
}) {
  const _onClick = () => {
    if (!disabled) onClick({ id, description, duration });
  };

  return (
    <button onClick={_onClick} className={`quest-card ${disabled && 'quest-card--disabled'}`}>
      <Avatar url={image} size={150} />
      <div className="column">
        <CardTitle className="quest-card__title">{description}</CardTitle>
        <CardDataList
          items={[
            `Duração: ${displayTime(duration)}`,
            `Experiência: ${experience}`,
            `Dinheiro: $ ${money}`,
          ]}
        />
      </div>
    </button>
  );
}

QuestCard.defaultProps = defaultProps;
