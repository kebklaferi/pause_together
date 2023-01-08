import logo from './logo.svg';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import Routing from "./components/routing/Routing";
import React from "react";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routing />
      </BrowserRouter>
    </div>
  );
}

export default App;
