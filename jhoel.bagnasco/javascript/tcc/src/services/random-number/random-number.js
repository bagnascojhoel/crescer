export const randomNumber = (rangeStart, rangeEnd) => {
  return Math.floor(Math.random() * (rangeEnd - rangeStart)) + rangeStart;
}