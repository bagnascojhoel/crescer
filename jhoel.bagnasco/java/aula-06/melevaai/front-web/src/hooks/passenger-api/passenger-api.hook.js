import { API_CONTEXT, useBaseAPI } from '../base-api/base-api.hook';

export function usePassengerAPI() {
  const baseAPI = useBaseAPI(API_CONTEXT.PASSENGER);

  const getAllPassengers = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data.map(mapResponseToPassenger);
    } catch (err) {
      console.error(`Error while trying to get all passengers: "${err}"`);
    }
  };

  const registerPassenger = async (passenger) => {
    try {
      const response = await baseAPI.post(
        '/',
        mapPassengerToRequest(passenger)
      );
      return response;
    } catch (err) {
      console.error(`Error while trying to register passenger: "${err}"`);
      const error = 'Não foi possível cadastrar passageiro.';
      return { error };
    }
  };

  const addMoneyPassenger = async (passengerCPF, money) => {
    try {
      const { data } = await baseAPI.put(
        `/${passengerCPF}/conta-virtual?valor=${money}`
      );
      return data;
    } catch (err) {
      console.error(`Error while trying to add money to passenger: "${err}"`);
    }
  };

  const getPassenger = async (passengerCPF) => {
    try {
      const { data } = await baseAPI.get(`/${passengerCPF}`);
      return mapResponseToPassenger(data);
    } catch (err) {
      console.error(`Error while trying to add money to passenger: "${err}"`);
    }
  };

  return {
    getAllPassengers,
    registerPassenger,
    addMoneyPassenger,
    getPassenger,
  };
}

function mapResponseToPassenger({
  cpf: { numero },
  nome,
  dataNascimento,
  carteiraVirtual,
  email,
  ...rest
}) {
  return {
    cpf: numero,
    name: nome,
    birthDate: dataNascimento,
    virtualWallet: carteiraVirtual,
    email,
    ...rest,
  };
}

function mapPassengerToRequest({ name, birthDate, cpf, email }) {
  return {
    nome: name,
    dataNascimento: birthDate,
    cpf,
    email,
  };
}
