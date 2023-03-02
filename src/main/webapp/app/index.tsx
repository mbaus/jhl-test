import React from 'react';
import { createRoot } from 'react-dom/client';
import './index.css';
import App from '@/common/primary/app/App';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Beers from "./beers/beers";

const container = document.getElementById('root');
const root = createRoot(container!);
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/beers" element={<Beers />} />
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
