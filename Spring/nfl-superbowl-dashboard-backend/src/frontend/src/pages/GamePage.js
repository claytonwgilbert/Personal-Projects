import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailsCard } from '../components/GameDetailsCard';
import { YearSelector } from '../components/YearSelector';
import './GamePage.scss';

export const GamePage = () => {

    const [game, setGame] = useState([]);
    const [team, setTeam] = useState(false);
    const {teamName} : {teamName : string} = useParams();
    const {year} : {year : string} = useParams();

    useEffect(
        () => {
            const getGameForYear = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}/game?year=${year}`);
                const response2 = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                const data2 = await response2.json();
                setGame(data);
                setTeam(data2);
            };
            getGameForYear();

        }, [teamName, year] // - Use as empty array as second argument to prevent this from calling the api indefinitely, endlessly
        //looping. Now it will call the api on the first page load only. If you have an argument, then
        //anytime that argument changes value, this code will be ran again. Here we have teamName because
        //when we go to click on a team name we want to see its page, meaning new data needs fetched. So
        //the team name grabbed from the url changes, then the page gets reloaded with data matching new
        //team name. This is called hooks
    );

    if(!game || !team){
        return <h1>Loading...</h1>
    }

    return (
        <div className="GamePage">
            <div className="year-selector">
                <h3>Past Appearances</h3>
                <YearSelector team={team} />
            </div>
            <div>
                <h1>Game Info:</h1>
                {
                    <GameDetailsCard teamName={teamName} game={game}/>
                }
            </div> 
        </div>
    );
}
