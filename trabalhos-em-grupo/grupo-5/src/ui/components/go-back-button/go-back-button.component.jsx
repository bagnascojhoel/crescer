import React from 'react';
import './style.css';
import { RiArrowGoBackLine } from 'react-icons/ri';
import { useHistory } from 'react-router-dom';

export function GoBackButton({}) {
  const { goBack } = useHistory();

  return (
    <button onClick={goBack} className="go-back-button">
      <RiArrowGoBackLine size={24} color={'#d7b55e'}/>
    </button>
  );
}
