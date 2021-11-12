import { React } from 'react';
import { Link } from 'react-router-dom';

export const GameDetailsCard = ({game, teamName}) => {
    
     if (!game) return null;
        const otherTeam = game.winner === teamName ? game.loser : game.winner;
        const otherTeamRoute = `/teams/${otherTeam}`;
        return(
            <div className="GameDetailsCard">
                <h3>Latest Appearances</h3>
                <h1>vs 
                    <Link to={otherTeamRoute}> {otherTeam}</Link></h1>
                <h2>{game.sbDate}</h2>
                <h3>at {game.stadium}</h3>
                <h3>{game.winner} won with a score of {game.winnerPts}</h3>
            </div>
    );
}