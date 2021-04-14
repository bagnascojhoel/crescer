import React from 'react';
import './App.css';
import { HeroCard } from './components/hero-card';
import heroes from './heroes-mock';

const colorReducer = (finalColor, item) =>
  item === 'bg' ? finalColor : finalColor + item + ' ';

const mapToHeroCard = ({ name, description, color, image, background }, i) =>
  name && description && image ? (
    <HeroCard
      key={i}
      name={name}
      description={description}
      backgroundColor={color?.split('-').reduce(colorReducer, '')}
      avatarImage={image}
      backgroundImage={background}
    />
  ) : (
    <HeroCard key={i} />
  );

function App() {
  const heroCards = heroes.map(mapToHeroCard);

  return (
    <div className="container">
      <h1>Seleção de Heróis</h1>
      <section className="heros-list">{heroCards}</section>
    </div>
  );
}

export default App;
