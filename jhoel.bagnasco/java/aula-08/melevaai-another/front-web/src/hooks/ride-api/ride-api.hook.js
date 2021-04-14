import { API_CONTEXT, useBaseAPI } from '../base-api/base-api.hook';
import { mapVeiculoToVehicle, mapPassageiroToPassenger } from '../maps';

export function useRideAPI() {
  const baseAPI = useBaseAPI(API_CONTEXT.RIDE);

  const getRideHistoryByCPF = async (CPF) => {
    try {
      const { data } = await baseAPI.get(`passageiros/${CPF}`);
      return data.map(mapResponseToRide);
    } catch (err) {
      console.error(`Error while trying to get ride history by CPF: "${err}"`);
    }
  };

  const requestRide = async (passengerCPF, startingPoint, endingPoint) => {
    try {
      const { data } = await baseAPI.post(
        `/passageiros/${passengerCPF}`,
        mapPointsToRequest({ startingPoint, endingPoint })
      );
    } catch (err) {
      console.error(`Error while trying to request ride: "${err}"`);
    }
  };

  const finishRide = async (rideCode) => {
    try {
      const { data } = await baseAPI.put(`${rideCode}`);
      return data;
    } catch (err) {
      console.error(`Error while trying to finish ride: "${err}"`);
    }
  };

  const startRide = async (rideID) => {
    try {
      const { data } = await baseAPI.post(`${rideID}`);
    } catch (err) {
      console.error(`Error while trying to start ride: "${err}"`);
    }
  };

  const listOnGoingRides = async () => {
    try {
      const { data } = await baseAPI.get('/em-andamento');
      return data.map(mapResponseToRide);
    } catch (err) {
      console.error(`Error while trying to list on going rides: "${err}"`);
    }
  };

  const rateDriver = async (rideID, score) => {
    try {
    } catch (err) {
      console.error(`Error while trying to rate driver: "${err}"`);
    }

    const { data } = await baseAPI.post(
      `/${rideID}/motoristas/avaliacao?nota=${score}`
    );

    return data;
  };

  const ratePassenger = async (rideID, score) => {
    try {
      const { data } = await baseAPI.post(
        `/${rideID}/passageiros/avaliacao?nota=${score}`
      );
      return data;
    } catch (err) {
      console.error(`Error while trying to rate passenger: "${err}"`);
    }
  };

  return {
    getRideHistoryByCPF,
    requestRide,
    finishRide,
    startRide,
    listOnGoingRides,
    rateDriver,
    ratePassenger,
  };
}

function mapPointsToRequest({ startingPoint, endingPoint }) {
  return {
    inicio: startingPoint,
    fim: endingPoint,
  };
}

function mapResponseToRide({
  identificador,
  dataHoraInicio,
  dataHoraFim,
  inicio,
  fim,
  notaParaMotorista,
  notaParaPassageiro,
  status,
  tempoChegada,
  tempoEstimado,
  valorEstimado,
  valorReal,
  passageiro,
  veiculo,
}) {
  return {
    id: identificador,
    startingTimeDate: dataHoraInicio,
    endingTimeDate: dataHoraFim,
    startingPoint: inicio,
    endingPoint: fim,
    driverScore: notaParaMotorista,
    passengerScore: notaParaPassageiro,
    arrivalTime: tempoChegada,
    expectedArrivalTime: tempoEstimado,
    expectedValue: valorEstimado,
    actualValue: valorReal,
    passenger: mapPassageiroToPassenger(passageiro),
    vehicle: mapVeiculoToVehicle(veiculo),
    status,
  };
}
