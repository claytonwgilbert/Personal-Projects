import { React } from 'react';
import {HashRouter as Router, Route} from 'react-router-dom';
import {Routes} from 'react-router';
import './App.scss';
import {GamePage} from "./pages/GamePage";
import {TeamPage} from "./pages/TeamPage";
import {HomePage} from "./pages/HomePage";


function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/teams/:teamName" element={<TeamPage />}></Route>
          <Route path="/teams/:teamName/game/:year" element={<GamePage />}></Route>
          <Route path="/" element={<HomePage />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
