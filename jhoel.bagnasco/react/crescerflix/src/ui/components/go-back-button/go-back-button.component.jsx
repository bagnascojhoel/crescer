import React from 'react';
import { useHistory } from 'react-router-dom';
import './styles.css';
import { COLORS } from '../../colors';
import { MdArrowBack } from 'react-icons/md';

export const GoBackButton = () => {
  const { goBack } = useHistory();

  return (
    <>
      <button onClick={goBack} className="go-back-button">
        <MdArrowBack color={COLORS.GRAY} size={36} />
      </button>
    </>
  );
};
