import React, { useEffect, useState } from 'react';
import { useParams, useHistory } from 'react-router-dom';
import { useUserMeAPI } from '../../../hooks';
import { Header } from '../../components';
import { ROUTES } from '../../../routes';
import {
  RiHeartFill,
  RiKnifeBloodLine,
  RiMoneyDollarCircleFill,
  RiShieldFill,
  RiSkullFill,
  RiSwordFill,
} from 'react-icons/ri';
import './style.css';

export function CharacterDetailsScreen() {
  const { replace } = useHistory();
  const { characterID } = useParams();
  const userMeAPI = useUserMeAPI();
  const [character, setCharacter] = useState(null);

  useEffect(() => {
    async function getCharacter() {
      const character = await userMeAPI.getMyCharacterByID(characterID);

      setCharacter(character);
    }

    getCharacter();
  }, []);

  async function handleClickDeleteCharacter() {
    const response = await userMeAPI.deleteMyCharacter(characterID);

    if (response.status !== 200) alert('Não foi possível excluir o personagem');
    else {
      alert('Personagem excluído!');
      replace(ROUTES.CHARACTER_SELECTION);
    }
  }

  return (
    <div className="container">
      <Header
        title="Informações do Personagem "
        buttonName="Excluir"
        to=""
        onClick={handleClickDeleteCharacter}
      />
      <div className="character-details-container">
        {character && <Character character={character} />}
      </div>
    </div>
  );
}

function Character({ character }) {
  const { race, items } = character;

  return (
    <div className="details-card">
      <div className="character-content">
        <img src={race.image} alt={`Ilustração da raça ${race.name}`} />
        <div className="info-container">
          <div className="character-info">
            <h2>{character.name}</h2>
            <div className="character-details">
              <div className="character-details-info">
                <p>Raça: {race.name}</p>
                <p>Nível: {character.level}</p>
                <p>XP: {character.experience}</p>
                <p>XP próximo nível: {character.experienceToNextLevel}</p>
              </div>
              <div className="character-details-info">
                <p> Status: {character.busy ? 'Ocupado' : 'Disponível'}</p>
                <p>
                  <RiMoneyDollarCircleFill /> Dinheiro: {character.money}
                </p>
                <p>
                  <RiSkullFill /> Mortes: {character.deaths}
                </p>
                <p>
                  <RiKnifeBloodLine /> Abates: {character.kills}
                </p>
              </div>
            </div>
          </div>
          <div className="footer">
            <div className="footer-item">
              <RiHeartFill /> Vida: {character.totalLife}
            </div>
            <div className="footer-item">
              <RiShieldFill /> Vigor: {character.totalVigor}
            </div>
            <div className="footer-item">
              <RiSwordFill /> Dano: {character.totalDamage}
            </div>
          </div>
        </div>
      </div>

      <div className={`items ${(items.length === 0) && 'item--hidden'}`}>
        <p>Itens: </p>
        <div className="item">
          {items.map((item) => (
            <>
              <p>{item.name}</p>
              <img src={item.image} />
            </>
          ))}
        </div>
      </div>
    </div>
  );
}
