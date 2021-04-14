import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import './index.css';
import App from './App';
import {
  UserProvider,
  CharacterProvider,
  OnGoingQuestProvider,
} from './context';

ReactDOM.render(
  <BrowserRouter>
    <UserProvider>
      <CharacterProvider>
        <App />
      </CharacterProvider>
    </UserProvider>
  </BrowserRouter>,
  document.getElementById('root')
);
