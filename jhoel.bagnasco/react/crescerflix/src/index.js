import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import './index.css';
import App from './App';
import { WatchlistProvider } from './context';

ReactDOM.render(
  <BrowserRouter>
    <WatchlistProvider>
      <App />
    </WatchlistProvider>
  </BrowserRouter>,
  document.getElementById('root')
);
