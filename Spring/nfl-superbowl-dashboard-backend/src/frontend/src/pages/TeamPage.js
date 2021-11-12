import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailsCard } from '../components/GameDetailsCard';
import { GameSmallCard } from '../components/GameSmallCard';
import { stringify } from 'query-string';


export const TeamPage = () => {

    const [team, setTeam] = useState({gamesPlayed: []});
    const {teamName} : {teamName : string} = useParams();

    useEffect(
        () => {
            const fetchMatches = async () => {
                console.log();
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                console.log(response);
                const data = await response.json();
                setTeam(data);
            };
            fetchMatches();
            
        }, [teamName] // - Use as empty array as second argument to prevent this from calling the api indefinitely, endlessly 
                      //looping. Now it will call the api on the first page load only. If you have an argument, then
                      //anytime that argument changes value, this code will be ran again. Here we have teamName because
                      //when we go to click on a team name we want to see its page, meaning new data needs fetched. So
                      //the team name grabbed from the url changes, then the page gets reloaded with data matching new
                      //team name. This is called hooks
    );

    if(!team || !team.teamName){
        return <h1>Team not found</h1>
    }

    return (
        <div className="TeamPage">
            <h1>{team.teamName}</h1>
            <GameDetailsCard teamName={team.teamName} game={team.gamesPlayed[0]}/>
            {team.gamesPlayed.slice(1).map(game => <GameSmallCard teamName={team.teamName} game={game}/>)}
        </div>
    );
}
