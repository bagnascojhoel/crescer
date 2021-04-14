import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';
import { COLORS } from '../../colors';
import { MdArrowBack, MdArrowForward } from 'react-icons/md';

const PaginationArrowButton = ({ paramName, value, forward }) => {
  const iconColor = COLORS.GRAY;
  const iconSize = 20;

  return (
    <li className="pagination__button-container">
      <Link to={`?${paramName}=${value}`}>
        {forward ? (
          <MdArrowForward color={iconColor} size={iconSize} />
        ) : (
          <MdArrowBack color={iconColor} size={iconSize} />
        )}
      </Link>
    </li>
  );
};

const PaginationButton = ({ paramName, value, active }) => {
  return (
    <li className="pagination__button-container">
      <Link
        to={`?${paramName}=${value}`}
        className={`pagination__button ${
          active && 'pagination__button--active'
        }`}
      >
        {value}
      </Link>
    </li>
  );
};

const PaginationButtonSeparator = () => (
  <li className="pagination__button-container">
    <span className="pagination__button">...</span>
  </li>
);

const defaultParams = {
  paramName: 'page',
  last: 1,
  current: 1,
};

const OPTIONS_ASIDE = 2;
const INITIAL_PAGE = 1;

export const Pagination = ({ current, last, paramName, center }) => {
  const fixedCurrent = parseInt(current);
  let middlePages = [];
  let middleStart = fixedCurrent - OPTIONS_ASIDE;
  let middleEnd = fixedCurrent + OPTIONS_ASIDE;

  if (fixedCurrent - OPTIONS_ASIDE < INITIAL_PAGE) middleStart = INITIAL_PAGE;
  if (fixedCurrent + OPTIONS_ASIDE > last) middleEnd = last;

  for (let i = middleStart; i <= middleEnd; i++) {
    middlePages.push(
      <PaginationButton
        key={i}
        value={i}
        paramName={paramName}
        active={i === fixedCurrent}
      />
    );
  }

  return (
    <ul className={`pagination ${center && 'pagination--center'}`}>
      {fixedCurrent > INITIAL_PAGE && (
        <PaginationArrowButton paramName={paramName} value={fixedCurrent - 1} />
      )}

      {fixedCurrent - OPTIONS_ASIDE > INITIAL_PAGE && (
        <>
          <PaginationButton
            active={fixedCurrent === INITIAL_PAGE}
            value={INITIAL_PAGE}
            paramName={paramName}
          />
          <PaginationButtonSeparator />
        </>
      )}

      {middlePages}

      {fixedCurrent + OPTIONS_ASIDE < last && (
        <>
          <PaginationButtonSeparator />
          <PaginationButton
            active={fixedCurrent === last}
            value={last}
            paramName={paramName}
          />
        </>
      )}

      {fixedCurrent < last && (
        <PaginationArrowButton
          paramName={paramName}
          value={fixedCurrent - 1}
          forward
        />
      )}
    </ul>
  );
};

Pagination.defaultParams = defaultParams;
