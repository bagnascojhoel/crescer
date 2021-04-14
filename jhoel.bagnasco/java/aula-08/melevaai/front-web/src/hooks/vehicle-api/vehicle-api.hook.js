import { API_CONTEXT, useBaseAPI } from '../base-api/base-api.hook';
import { mapMotoristaToDriver } from '../maps';

export function useVehicleAPI() {
  const baseAPI = useBaseAPI(API_CONTEXT.VEHICLE);

  const getAllVehicles = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data.map(mapResponseToVehicle);
    } catch (err) {
      console.error(`Error while trying to get all vehicles: "${err}"`);
    }
  };

  const registerVehicle = async (vehicle) => {
    try {
      const { data } = await baseAPI.post('/', mapVehicleToRequest(vehicle));
      return data;
    } catch (err) {
      console.error(`Error while trying to register vehicle: "${err}"`);
      return {
        error: 'Não foi possível cadastrar veículo.',
      };
    }
  };

  const getCategories = async () => {
    try {
      const { data } = await baseAPI.get('/categorias');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all categories: "${err}"`);
    }
  };

  const getColors = async () => {
    try {
      const { data } = await baseAPI.get('/cores');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all colors: "${err}"`);
    }
  };

  const getBrands = async () => {
    try {
      const { data } = await baseAPI.get('/marcas');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all colors: "${err}"`);
    }
  };

  return {
    getAllVehicles,
    registerVehicle,
    getCategories,
    getColors,
    getBrands,
  };
}

function mapResponseToVehicle({
  proprietario,
  placa,
  marca,
  modelo,
  ano,
  cor,
  foto,
  categoria,
  qtdLugares,
  ...rest
}) {
  return {
    driver: mapMotoristaToDriver(proprietario),
    plate: placa.numero,
    brand: marca,
    model: modelo,
    year: ano,
    color: cor,
    photo: foto.url,
    category: categoria,
    qtySeats: qtdLugares,
    ...rest,
  };
}

function mapVehicleToRequest({
  driver,
  plate,
  brand,
  model,
  year,
  color,
  photo,
  category,
  qtySeats,
}) {
  return {
    cpfproprietario: driver.cpf,
    placa: plate,
    marca: brand,
    modelo: model,
    ano: year,
    cor: color,
    foto: photo,
    categoria: category,
    qtdLugares: qtySeats,
  };
}
