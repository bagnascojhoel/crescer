import React, { useEffect, useState } from 'react';
import { Title, TvShowCardList, ListWithPagination } from '../../components';
import { useTvShowsAPI } from '../../../hooks';

const INITIAL_PAGE = 1;
const API = useTvShowsAPI();
export const TvShowsScreen = () => {
  const [currentPage, setCurrentPage] = useState(undefined);
  const [lastPage, setLastPage] = useState(undefined);
  const [pageItems, setPageItems] = useState([]);

  useEffect(() => {
    (async () => {
      const { list, totalPages } = await API.getTvShowsPage(
        currentPage || INITIAL_PAGE
      );

      setLastPage(totalPages);
      setPageItems(list);
    })();
  }, [currentPage]);

  const handlePageChange = (newPage) => {
    setCurrentPage(parseInt(newPage));
  };

  return (
    <div className="container">
      <Title>Séries</Title>
      <ListWithPagination lastPage={lastPage} onPageChange={handlePageChange}>
        <TvShowCardList items={pageItems} />
      </ListWithPagination>
    </div>
  );
};
