import React from 'react';
import './App.css';
import { FighterSelectionScreen } from './screens';

function App() {
  return (
    <div className="App">
      <img
        className="App__logo"
        src="https://1.bp.blogspot.com/-_ASt7_Oz-3o/V_L8lIZGUUI/AAAAAAAACvs/yNBii7L57fcnSSMtrpbjn57htRDBzNM2ACPcB/s1600/mk2-screenshot02.png"
        alt=""
      />
      <h1 className="App__title">Choose your fighter</h1>
      <FighterSelectionScreen />
    </div>
  );
}

export default App;
