import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailsCard } from '../components/GameDetailsCard';
import { GameSmallCard } from '../components/GameSmallCard';

export const GamePage = () => {


    const [team, setTeam] = useState({gamesPlayed: []});
    const {teamName} : {teamName : string} = useParams();

    if(!team || !team.teamName){
        return <h1>Team not found</h1>
    }

    return (
        <div className="MatchPage">
            <h1>{team.teamName}</h1>
            <GameDetailsCard teamName={team.teamName} game={team.gamesPlayed[0]}/>
            {team.gamesPlayed.slice(1).map(game => <GameSmallCard teamName={team.teamName} game={game}/>)}
        </div>
    );
}
