import React, { useEffect, useState } from 'react';
import { DogAPI } from '../../../hooks';
import {
  Title,
  DogAvatarButtonList,
  DogAvatarButtonAdd,
} from '../../components';

const INITIAL_DOGS_QTY = 10;

const extractId = (dogImageURL) => {
  const idWithExtension = dogImageURL.split('/').pop();
  const id = idWithExtension.split('.')[0];
  return id;
};

const dogAPI = DogAPI();

export const DogListScreen = () => {
  const [dogs, setDogs] = useState([]);

  useEffect(() => {
    (async () => {
      const dogs = await dogAPI.getRandomDogImages(INITIAL_DOGS_QTY);
      const mappedDogs = dogs.map((dogImage) => ({
        dogImage,
        id: extractId(dogImage),
      }));

      setDogs(mappedDogs);
    })();
  }, []);

  const handleRemoveDog = (idToRemove) => {
    console.log(idToRemove);
    const newDogs = dogs.filter(({ id }) => id !== idToRemove);
    setDogs(newDogs);
  };

  const handleAddDog = async () => {
    const dogImage = await dogAPI.getRandomDogImage();
    const newDog = { dogImage, id: extractId(dogImage) };

    setDogs([...dogs, newDog]);
  };

  return (
    <>
      <Title>Cachorrinhos</Title>
      <div>
        <DogAvatarButtonAdd onAdd={handleAddDog}>Adicionar </DogAvatarButtonAdd>
      </div>
      <DogAvatarButtonList dogs={dogs} onRemove={handleRemoveDog} />
    </>
  );
};
