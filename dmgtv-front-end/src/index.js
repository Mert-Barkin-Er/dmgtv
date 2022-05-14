import React from 'react';
import ReactDOM from 'react-dom/client';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import './index.css';
import App from './App';
import ProfilePage from './components/ProfilePage';
import FriendsPage from './components/FriendsPage';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App/>}/>
        <Route path='/profile' element={<ProfilePage/>}/>
        <Route path='/friends' element={<FriendsPage/>}/>
      </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
