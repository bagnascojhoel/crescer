import axios from 'axios';

const mapItem = ({ id, nome, tipo, preco, aprimoramento }) => ({
  id,
  name: nome,
  type: tipo,
  price: preco,
  enhancement: aprimoramento,
});

const getRemoteItems = async () => {
  try {
    const remoteItems = await axios.get('http://tcc-js.surge.sh/itens');

    // const remoteItems = { data: mock };
    
    return remoteItems.data;
  } catch (error) {
    throw `Error while trying to get remote items: ${error}`;
  }
};

export const getAllItems = async () => {
  try {
    const remoteItems = await getRemoteItems();

    return remoteItems.map(mapItem);
  } catch (error) {
    console.error(`Error while getting items: ${error}`);
  }
};

export const getItemById = async (askedId) => {
  try {
    const remoteItems = await getRemoteItems();
    const item = remoteItems.find(({ id }) => id == askedId);

    return item ? mapItem(item) : null;
  } catch (error) {
    console.error(`Error while trying to get item by id: ${error}`);
  }
};

const mock = [
  {
    id: 1,
    nome: 'Espada curta',
    tipo: 'DANO',
    preco: 40,
    aprimoramento: 3,
  },
  {
    id: 2,
    nome: 'Espada longa',
    tipo: 'DANO',
    preco: 90,
    aprimoramento: 7,
  },
  {
    id: 3,
    nome: 'Espada de Chessus',
    tipo: 'DANO',
    preco: 2000,
    aprimoramento: 90,
  },
  {
    id: 4,
    nome: 'Chicote do Tinhoso',
    tipo: 'DANO',
    preco: 2000,
    aprimoramento: 90,
  },
  {
    id: 5,
    nome: 'Talismã de vida P',
    tipo: 'VIDA',
    preco: 40,
    aprimoramento: 3,
  },
  {
    id: 6,
    nome: 'Talismã de vida M',
    tipo: 'VIDA',
    preco: 90,
    aprimoramento: 7,
  },
  {
    id: 7,
    nome: 'Talismã de Chessus',
    tipo: 'VIDA',
    preco: 2000,
    aprimoramento: 90,
  },
  {
    id: 8,
    nome: 'Talismã do Tinhoso',
    tipo: 'VIDA',
    preco: 2000,
    aprimoramento: 90,
  },
  {
    id: 9,
    nome: 'Bracelete de vigor P',
    tipo: 'VIGOR',
    preco: 40,
    aprimoramento: 3,
  },
  {
    id: 10,
    nome: 'Bracelete de vigor M',
    tipo: 'VIGOR',
    preco: 90,
    aprimoramento: 7,
  },
  {
    id: 11,
    nome: 'Bracelete de Chessus',
    tipo: 'VIGOR',
    preco: 2000,
    aprimoramento: 90,
  },
  {
    id: 12,
    nome: 'Bracelete do Tinhoso',
    tipo: 'VIGOR',
    preco: 2000,
    aprimoramento: 90,
  },
];
