import { randomNumber } from '../src/services/random-number/random-number';
describe('Suíte: funções auxiliares', () => {
  it('Deve ter apenas números menores ou iguais a 12 quando utilizar "randomNumber(3, 12)"', () => {
    const receivedArr = [
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
    ];

    receivedArr.forEach((received) => {
      expect(received).toBeLessThanOrEqual(12);
    });
  });

  it('Deve ter apenas números maiores ou iguais a 3 quando utilizar "randomNumber(3, 12)"', () => {
    const receivedArr = [
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
      randomNumber(3, 12),
    ];

    receivedArr.forEach((received) => {
      expect(received).toBeGreaterThanOrEqual(3);
    });
  });
});
