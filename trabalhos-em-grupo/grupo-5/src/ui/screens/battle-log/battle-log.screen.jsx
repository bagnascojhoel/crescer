import React, { useEffect, useState } from 'react';
import './style.css';
import { useParams } from 'react-router-dom';
import { CardList, Header, BattleLogMessage, Avatar } from '../../components';
import { useCharactersAPI, useUserMeAPI } from '../../../hooks';
import { useGlobalCharacter } from '../../../context';

export function BattleLogScreen() {
  const userMeAPi = useUserMeAPI();
  const charactersAPI = useCharactersAPI(); 
  const { opponentID, opponentName } = useParams();
  const [globalCharacter] = useGlobalCharacter();
  const [battleLog, setBattleLog] = useState([]);
  const [winnerName, setWinnerName] = useState('');
  const [opponentImage, setOpponentImage] = useState('')

  useEffect(() => {
    async function battle() {
      const battleLog = await userMeAPi.battleAgainst(
        globalCharacter.id,
        opponentID
      );

      const opponent = await charactersAPI.getCharactersByName(opponentName)

      setOpponentImage(opponent[0].race.image)
      setWinnerName(battleLog.winner ? globalCharacter.name : opponentName);
      setBattleLog(battleLog.battleLogs);
    }

    battle();
  }, []);

  return (
    <>
      <div className="container">
        <Header
          title={`Batalha entre ${globalCharacter.name} e ${opponentName}`}
        />
        <div className="battle-log-images">
        <Avatar url={globalCharacter.race.image} size={150} />
        <Avatar url={opponentImage} size={150} />
        </div>
        <CardList
          items={battleLog}
          of={BattleLogMessage}
          keyExtractor={({ id }) => id}
          column
        />

        <div className="battle-log__winner">
          <div>
            <h3>Vencedor: {winnerName}</h3>
          </div>
        </div>
      </div>
    </>
  );
}
