import { React } from 'react';
import {BrowserRouter as Router, Route} from 'react-router-dom';
import {Routes} from 'react-router';
import './App.css';
import {GamePage} from "./pages/GamePage";
import {TeamPage} from "./pages/TeamPage";


function App() {
  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/teams/:teamName" element={<TeamPage />}></Route>
          <Route path="/teams/:teamName/game/:year" element={<GamePage />}></Route>
        </Routes>
      </Router>
    </div>
  );
}

export default App;
