import React, { useEffect, useState } from 'react';
import { Header, QuestCard, CardList } from '../../components';
import { useQuestAPI, useQuestHelper } from '../../../hooks';
import { useGlobalCharacter } from '../../../context';

const mock = [
  {
    id: 1,
    description: 'Limpar os canecos da taberna',
    duration: 5000,
    experience: 50,
    money: 10,
    image:
      'https://i.pinimg.com/564x/2f/34/00/2f34004926369f320231b49e26166f70.jpg',
  },
  {
    id: 2,
    description: 'Limpar a taberna',
    duration: 15000,
    experience: 50,
    money: 20,
    image:
      'https://i.pinimg.com/564x/fa/b1/85/fab185174be1fc6d2ae3d0647c0a18fd.jpg',
  },
  {
    id: 3,
    description: 'Batalhar contra Murloc',
    duration: 20000,
    experience: 100,
    money: 5,
    image:
      'https://i.pinimg.com/564x/6b/5d/1b/6b5d1b7af26077c35293af7c423511d9.jpg',
  },
];

export function TavernScreen() {
  const [quests, setQuests] = useState([]);
  const [character] = useGlobalCharacter();
  const questAPI = useQuestAPI();
  const questHelper = useQuestHelper();
  const { busy } = character ?? {};

  useEffect(() => {
    (async () => {
      const remoteQuests = (await questAPI.getAllQuests()) || mock;
      setQuests(remoteQuests);
    })();
  }, []);

  const handleSelectQuest = ({ id, duration, description }) => {
    questHelper.startQuest(id, duration, description);
  };

  return (
    <div className="container">
      <Header title="Taverna" />
      <CardList
        of={QuestCard}
        items={quests}
        keyExtractor={({ id }) => id}
        onClick={handleSelectQuest}
        disabled={busy}
      />
    </div>
  );
}
