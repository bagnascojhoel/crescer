import axios from 'axios';

export const DogAPI = () => {
  const httpClient = axios.create({
    baseURL: 'https://dog.ceo/api/breeds',
  });

  const getRandomDogImage = async () => {
    return (await httpClient.get('/image/random')).data.message;
  };

  const getRandomDogImages = async (qty) => {
    return (await httpClient.get(`/image/random/${qty}`)).data.message;
  };

  return { getRandomDogImage, getRandomDogImages };
};
