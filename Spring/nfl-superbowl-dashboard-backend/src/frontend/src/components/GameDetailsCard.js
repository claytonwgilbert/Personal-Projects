import { React } from 'react';
import { Link } from 'react-router-dom';
import './GameDetailsCard.scss';


export const GameDetailsCard = ({teamName, game}) => {
    
     if (!game) return null;
        const otherTeam = game.winner === teamName ? game.loser : game.winner;
        const otherTeamRoute = `/teams/${otherTeam}`;
        const isTeamWon = teamName === game.winner;
        return(
            <div className={isTeamWon ? 'GameDetailsCard won-card' : 'GameDetailsCard lost-card'}>
                <div className="main-game-details">
                    <h3>Latest Appearances</h3>
                    <span className="vs">vs</span>
                    <h1><Link to={otherTeamRoute}> {otherTeam}</Link></h1>
                    <h2 className="game-date">{game.sbDate}</h2>
                    <h3 className="game-stadium">at {game.stadium}</h3>
                    <h3 className="game-result">{game.winner} won with a score of {game.winnerPts}</h3>
                </div>
                <div className="additional-details">
                    <h3>MVP</h3>
                    <p>{game.mvp}</p>
                    <h3>City, State</h3>
                    <p>{game.city}, {game.state}</p>
                </div>
            </div>
    );
}