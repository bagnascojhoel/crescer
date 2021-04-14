import React from 'react';
import { Avatar, TextWithTitle } from '../../../components';

export function VehicleDataListItem({ data: vehicle }) {
  return (
    <>
      <Avatar url={vehicle.photo} />
      <TextWithTitle title="Placa" text={vehicle.plate} />
      <TextWithTitle title="Motorista" text={vehicle.driver.name} />
      <TextWithTitle title="Cor" text={vehicle.color} />
    </>
  );
}
