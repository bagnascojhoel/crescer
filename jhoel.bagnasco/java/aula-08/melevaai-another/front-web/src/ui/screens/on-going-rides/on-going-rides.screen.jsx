import React, { useEffect, useState } from 'react';
import { MdCheck, MdPlayArrow } from 'react-icons/md';
import { useGlobalPassenger } from '../../../context';
import { usePassengerAPI, useRideAPI } from '../../../hooks';
import {
  LayoutContainer,
  DataList,
  TextWithTitle,
  SquareButton,
} from '../../components';

export function OnGoingRidesScreen() {
  const rideAPI = useRideAPI();
  const passengerAPI = usePassengerAPI();
  const [globalPassenger, setGlobalPassenger] = useGlobalPassenger();
  const [onGoingRides, setOnGoingRides] = useState([]);
  const keyExtractor = ({ id }) => id;

  useEffect(() => updateList(), []);

  const updateList = async () => {
    const response = await rideAPI.listOnGoingRides();
    setOnGoingRides(response);
  };

  const handleStartRide = async (rideID) => {
    await rideAPI.startRide(rideID);
    updateList();
  };

  const handleFinishRide = async (rideID) => {
    await rideAPI.finishRide(rideID);
    updateList();
    const passenger = await passengerAPI.getPassenger(globalPassenger.cpf);
    setGlobalPassenger({ ...passenger });
  };

  return (
    <LayoutContainer>
      <DataList
        itemComponent={OnGoingRideDataListItem}
        dataList={onGoingRides}
        keyExtractor={keyExtractor}
        onStartRide={handleStartRide}
        onFinishRide={handleFinishRide}
      />
    </LayoutContainer>
  );
}

function OnGoingRideDataListItem({ data: ride, onStartRide, onFinishRide }) {
  const _onStartRide = () => {
    onStartRide(ride.id);
  };

  const _onFinishRide = () => {
    onFinishRide(ride.id);
  };

  return (
    <>
      <TextWithTitle title="Identificador" text={ride.id} />
      <TextWithTitle title="Passageiro" text={ride.passenger.name} />
      <TextWithTitle title="Motorista" text={ride.vehicle.driver.name} />
      <TextWithTitle title="Status" text={ride.status} />

      {ride.status === 'CHAMADA' && (
        <SquareButton onClick={_onStartRide} icon={MdPlayArrow} />
      )}

      {ride.status === 'INICIADA' && (
        <SquareButton onClick={_onFinishRide} icon={MdCheck} />
      )}
    </>
  );
}
