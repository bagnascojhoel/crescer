import React, { useEffect } from 'react';
import { Pagination } from '..';
import { useQuery } from '../../../hooks';
import './styles.css';

const defaultProps = {
  initialPage: 1,
  lastPage: 1,
  paramName: 'pagina',
};

export const ListWithPagination = ({
  initialPage,
  lastPage,
  paramName,
  onPageChange,
  children,
}) => {
  const page = useQuery().get(paramName) ?? initialPage;

  useEffect(() => {
    onPageChange(page);
  }, [page, onPageChange]);

  return (
    <div className="list-with-pagination">
      <div className="list-with-pagination__list-container">{children}</div>
      <Pagination last={lastPage} current={page} paramName={paramName} />
    </div>
  );
};

ListWithPagination.defaultProps = defaultProps;
