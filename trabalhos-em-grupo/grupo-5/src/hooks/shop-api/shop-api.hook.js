import { useAuthenticatedBaseAPI, API_CONTEXT } from '../';

export function useShopAPI() {
  const baseAPI = useAuthenticatedBaseAPI(API_CONTEXT.SHOP);

  const getAllItems = async () => {
    try {
      const { data } = await baseAPI.get('/');
      return data;
    } catch (err) {
      console.error(`Error while trying to get all items: "${err}"`);
    }
  };

  const getItemByID = async (itemID) => {
    try {
      const { data } = await baseAPI.get(`/${itemID}`);
      return data;
    } catch (err) {
      console.error(`Error while trying to get item by ID: "${err}"`);
    }
  };

  const buyItem = async (characterID, itemID) => {
    try {
      const body = { characterId: characterID };
      const { data } = await baseAPI.post(`/${itemID}/buy`, body);
      return { data };
    } catch (err) {
      console.error(`Error while trying to buy item: "${err}"`);
    }
  };

  const sellItem = async (characterID, itemID) => {
    try {
      const body = { characterId: characterID };
      const { data } = await baseAPI.post(`/${itemID}/sell`, body);
      return { data };
    } catch (err) {
      console.error(`Error while trying to sell item: "${err}"`);
    }
  };

  return {
    getAllItems,
    getItemByID,
    buyItem,
    sellItem,
  };
}
