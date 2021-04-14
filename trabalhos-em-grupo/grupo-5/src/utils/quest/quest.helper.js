const TIME_SYMBOLS = {
  SECONDS: 's',
  MINUTES: 'm',
  HOURS: 'h',
};

export function displayTime(timeInMs) {
  let timeSymbol = TIME_SYMBOLS.SECONDS;
  let time = timeInMs > 1000 ? timeInMs : 0;

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

export function hasEnded(endTime) {
  return endTime ? (Date.now() >= new Date(endTime)) : true;
}

