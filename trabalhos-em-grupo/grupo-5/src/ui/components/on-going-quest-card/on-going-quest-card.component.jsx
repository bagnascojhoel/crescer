import './style.css';
import React, { useEffect, useState } from 'react';
import { useGlobalCharacter, useGlobalOnGoingQuest } from '../../../context';
import { useCharacterHelper, useQuestAPI } from '../../../hooks';

/* Não deu : ( */

const TIME_SYMBOLS = {
  SECONDS: 's',
  MINUTES: 'm',
  HOURS: 'h',
};

function displayTime(timeInMs) {
  let timeSymbol = TIME_SYMBOLS.SECONDS;
  let time = timeInMs >= 1000 ? timeInMs : 1;

  if (time >= 1000) {
    time /= 1000;

    if (time >= 60) {
      time /= 60;
      timeSymbol = TIME_SYMBOLS.MINUTES;

      if (time >= 60) {
        time /= 60;
        timeSymbol = TIME_SYMBOLS.HOURS;
      }
    }
  }

  return `${Math.floor(time)} ${timeSymbol}`;
}

function calculateTimeLeft(endTime) {
  return new Date(endTime) - Date.now();
}

let countDown;
const CHECK_INTERVAL = 1000;

function startCountDown(updater) {
  const counter = () => {
    updater((old) => old - CHECK_INTERVAL);
  };

  countDown = setInterval(counter, CHECK_INTERVAL);
}

function endCountDown() {
  clearInterval(countDown);
  countDown = undefined;
}

export function OnGoingQuestCard() {
  const questAPI = useQuestAPI();
  const characterHelper = useCharacterHelper();
  const [timeLeft, setTimeLeft] = useState(0);
  const [character] = useGlobalCharacter();
  const { busy, questInProgress } = character ?? {};

  const endQuest = async () => {
    if (busy && calculateTimeLeft(questInProgress.finishAt) <= 0) {
      await questAPI.finishQuest(character.id);
      const newCharacter = { ...character, busy: false };
      characterHelper.select(newCharacter);
    }
  };

  useEffect(() => {
    endQuest();

    if (busy && calculateTimeLeft(questInProgress.finishAt) > 0) {
      setTimeLeft(calculateTimeLeft(questInProgress.finishAt));
      startCountDown(setTimeLeft);
    }
  }, [character]);

  useEffect(() => {
    if (timeLeft <= 0) endCountDown();
    endQuest();
  }, [timeLeft]);

  return <div></div>;
}
