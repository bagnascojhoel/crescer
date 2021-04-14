import axios from 'axios';

const httpClient = axios.create({
  baseURL: 'https://crescerflix.herokuapp.com/shows',
});

export const useTvShowsAPI = () => {
  const getTvShowTotalPages = async () =>
    (await httpClient.get('/')).data.totalPages;

  const getTvShowsPage = async (page) =>
    (await httpClient.get(`?page=${page}`)).data;

  const getTvShow = async (tvShowID) =>
    (await httpClient.get(`/${tvShowID}`)).data;

  return {
    getTvShowsPage,
    getTvShow,
    getTvShowTotalPages,
  };
};
