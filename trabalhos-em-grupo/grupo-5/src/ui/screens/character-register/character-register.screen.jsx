import './style.css';
import React, { useState, useEffect } from 'react';
import { useHistory } from 'react-router-dom';
import {
  Form,
  InputTextField,
  Header,
  ButtonContainer,
} from '../../components/';
import { RiHeartFill, RiShieldFill, RiSwordFill } from 'react-icons/ri';
import { useRacesAPI, useUserMeAPI } from '../../../hooks/';
import { ROUTES } from '../../../routes';

export function CharacterRegisterScreen() {
  const [races, setRaces] = useState([]);
  const racesApi = useRacesAPI();
  const userMeApi = useUserMeAPI();
  const { replace } = useHistory();
  const [name, setName] = useState('');
  const [raceId, setRaceId] = useState(0);
  const [faction, setFatcion] = useState('');

  function onChangeName(value) {
    setName(value);
  }

  function onChangeFaction(event) {
    setFatcion(event.target.value);
  }

  useEffect(() => {
    async function getRaces() {
      const racesList = await racesApi.getAllRaces();
      setRaces(racesList);
    }
    getRaces();
  }, []);

  function handleClickRace(selectedRace) {
    setRaceId(selectedRace);
  }

  async function onSubmit() {
    let response;
    if (raceId != 0) {
      response = await userMeApi.createCharacter(name, raceId, faction);
      if (!response) {
        alert('Use um nome diferente!')
      } else if (response.status === 201) {
        alert('Personagem criado!');
        replace(ROUTES.CHARACTER_SELECTION);
      }
    } else {
      alert('Você deve escolher uma raça!');
    }
  }

  return (
    <div className="container">
      <Form onSubmit={onSubmit}>
        <Header title="Criação de Personagem" />

        <div className="character-info">
          <div className="input-container">
            <InputTextField
              label="Nome"
              required
              name="nome"
              type="text"
              value={name}
              onChange={onChangeName}
            />
            <ButtonContainer>Criar</ButtonContainer>
          </div>

          <label className="faction-selection">
            Selecione uma facção:
            <div className="radio-buttons">
              <input
                onChange={onChangeFaction}
                type="radio"
                id="Horda"
                value="Horda"
                name="faction"
                required
              />
              <label for="Horda">Horda</label>
              <input
                onChange={onChangeFaction}
                type="radio"
                id="Aliança"
                value="Aliança"
                name="faction"
                required
              />
              <label for="Aliança">Aliança</label>
            </div>
          </label>
        </div>
        <p className="race-selection">Selecione a raça:</p>
      </Form>
      <RacesList races={races} handleClickRace={handleClickRace} />
    </div>
  );
}

function Race({
  id,
  name,
  image,
  baseLife,
  baseVigor,
  baseDamage,
  onClick,
  selected,
}) {
  function handleClickRace() {
    onClick(id);
  }

  return (
    <button
      className={`race ${selected && 'race--selected'} `}
      onClick={handleClickRace}
    >
      <img className="race-img" src={image} alt="imagem ilustrativa da raça" />
      <div className="race-info">
        <h2>{name}</h2>
        <div>
          <RiHeartFill /> Vida base: {baseLife}
        </div>
        <div>
          <RiShieldFill /> Vigor base: {baseVigor}
        </div>
        <div>
          <RiSwordFill /> Dano base: {baseDamage}
        </div>
      </div>
    </button>
  );
}

function RacesList({ races, handleClickRace }) {
  const [selectedID, setSelectedID] = useState(undefined);
  function onClick(id) {
    setSelectedID(id);
    handleClickRace(id);
  }

  return (
    <div className="races-list">
      {races.map((race, index) => (
        <Race
          key={index}
          id={race.id}
          name={race.name}
          image={race.image}
          baseLife={race.baseLife}
          baseVigor={race.baseVigor}
          baseDamage={race.baseDamage}
          onClick={onClick}
          selected={selectedID === race.id}
        />
      ))}
    </div>
  );
}
