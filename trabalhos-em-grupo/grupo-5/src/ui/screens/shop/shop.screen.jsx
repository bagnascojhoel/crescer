import React from 'react';
import './style.css';
import { useEffect, useState } from 'react';
import { Button, CardList, Header } from '../../components';
import { useCharacterHelper, useShopAPI, useUserMeAPI } from '../../../hooks';
import { useGlobalCharacter } from '../../../context';

const mockInvetoryItems = [
  {
    id: 1,
    name: 'Espada curta',
    type: 'DANO',
    price: 40,
    sellPrice: 20,
    enhancement: 3,
    image:
      'https://i.pinimg.com/564x/55/6a/2a/556a2a10ba02696da3ae13eefb657153.jpg ',
  },
  {
    id: 2,
    name: 'Espada longa',
    type: 'DANO',
    price: 90,
    sellPrice: 45,
    enhancement: 7,
    image:
      'https://i.pinimg.com/564x/b9/b3/e8/b9b3e8f7ffd35253e199a2fd516c8e99.jpg',
  },
  {
    id: 3,
    name: 'Espada de Chessus',
    type: 'DANO',
    price: 2000,
    sellPrice: 1000,
    enhancement: 90,
    image:
      'https://i.pinimg.com/564x/fa/7a/92/fa7a92c8dedab849112f68cfda7eafbf.jpg',
  },
];

function ItemCardPusrchase({
  id,
  name,
  type,
  price,
  enhancement,
  sellPrice,
  image,
  onPurchaseItem,
}) {
  function handleClick() {
    onPurchaseItem({ id, price, type, name, sellPrice, enhancement, image });
  }

  return (
    <div className="purchase-card item-card">
      <div className="item-card-text">
        <b>{name}</b>
        <span>Tipo de aprimoramento: {type}</span>
        <span>Valor do aprimoramento: {enhancement}</span>
      </div>
      <div className="item-content-box">
        <img className="item-image" src={image} />
        <Button secondary onClick={handleClick} noGutter>
          Comprar por <b>$ {price}</b>
        </Button>
      </div>
    </div>
  );
}

function ItemCardSell({
  id,
  name,
  type,
  sellPrice,
  price,
  enhancement,
  image,
  onSellItem,
}) {
  function handleClick() {
    onSellItem({ id, price, type, name, sellPrice, enhancement, image });
  }

  return (
    <div className="sell-card item-card">
      <div className="item-card-text">
        <b>{name}</b>
        <span>Tipo: {type}</span>
        <span>Valor: {enhancement}</span>
      </div>
      <div className="item-content-box">
        <img className="item-image" src={image} />
        <Button secondary onClick={handleClick} noGutter>
          Vender por <b>$ {sellPrice}</b>
        </Button>
      </div>
    </div>
  );
}

export function ShopScreen() {
  const shopApi = useShopAPI();
  const [character] = useGlobalCharacter();
  const characterHelper = useCharacterHelper();
  const [storeItems, setStoreItems] = useState([]);
  const [inventoryItems, setInventoryItems] = useState(character.items || []);

  useEffect(() => {
    (async () => {
      const store = await shopApi.getAllItems();
      setStoreItems(store);
    })();
  }, []);

  async function handlePurchaseItem(itemPurchase) {
    if (character.money < itemPurchase.price) {
      alert('Você não possui dinheiro suficiente para comprar este item!');
      return;
    }
    const response = await shopApi.buyItem(character.id, itemPurchase.id);
    if (!response) {
      alert('Você não pode comprar um item que já possui!');
    } else {
      const newItems = [...character.items, itemPurchase];
      const newCharacter = { ...character, items: newItems };
      characterHelper.select(newCharacter);
      setInventoryItems(newItems);

      alert('Item adquirido!');
    }
  }

  async function handleSellItem(itemSell) {
    await shopApi.sellItem(character.id, itemSell.id);

    const newItems = character.items.filter(({ id }) => id !== itemSell.id);
    const newCharacter = { ...character, items: newItems };
    characterHelper.select(newCharacter);
    setInventoryItems(newItems);

    alert('Item vendido!');
  }

  return (
    <div className="container shop">
      <Header title="Loja" />
      <div className="store-items">
        <CardList
          items={storeItems}
          of={ItemCardPusrchase}
          keyExtractor={(item) => item.id}
          onPurchaseItem={handlePurchaseItem}
        />
        <div className="sell-cards-list">
          <b className="inventory-title">Inventário</b>
          <CardList
            items={inventoryItems}
            of={ItemCardSell}
            keyExtractor={(item) => item.id}
            onSellItem={handleSellItem}
          />
        </div>
      </div>
    </div>
  );
}
