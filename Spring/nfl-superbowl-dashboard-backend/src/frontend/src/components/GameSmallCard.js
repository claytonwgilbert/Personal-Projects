import { React } from 'react';
import { Link } from 'react-router-dom';
import './GameSmallCard.scss';

export const GameSmallCard = ({game, teamName}) => {

    if (!game) return null;
        const otherTeam = game.winner === teamName ? game.loser : game.winner;
        const otherTeamRoute = `/teams/${otherTeam}`;
        const isTeamWon = teamName === game.winner;

        return (
            <div className={isTeamWon ? 'GameSmallCard won-card' : 'GameSmallCard lost-card'}>
                <span className="vs">vs</span>
                <h1><Link to={otherTeamRoute}> {otherTeam}</Link></h1>
                <p className="game-result">{game.winner} won with a score of {game.winnerPts}</p>
            </div>
        );
}