import { React } from 'react';
import { Link } from 'react-router-dom';

export const GameSmallCard = ({game, teamName}) => {

    if (!game) return null;
        const otherTeam = game.winner === teamName ? game.loser : game.winner;
        const otherTeamRoute = `/teams/${otherTeam}`;
        return (
            <div className="GameSmallCard">
                <h3>vs 
                    <Link to={otherTeamRoute}> {otherTeam}</Link></h3>
                <p>{game.winner} won with a score of {game.winnerPts}</p>
            </div>
        );
}