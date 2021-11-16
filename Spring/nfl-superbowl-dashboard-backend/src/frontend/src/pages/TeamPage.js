import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailsCard } from '../components/GameDetailsCard';
import { GameSmallCard } from '../components/GameSmallCard';
import { PieChart } from 'react-minimal-pie-chart';
import { Link } from 'react-router-dom';
import './TeamPage.scss';


export const TeamPage = () => {

    const [team, setTeam] = useState({gamesPlayed: []});
    const {teamName} : {teamName : string} = useParams();

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
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
        return <h1>Loading...</h1>
    }

    let years = team.gamesPlayed.map(date => date.sbDate.split('-'));

    return (
        <div className="TeamPage">
            <div className="team-name-div">
                <h1 className="team-name">{team.teamName}</h1>
            </div>
            <div className="team-wins-losses-section">
                Wins/Losses
                <PieChart
                        data={[
                            { title: 'Losses', value: team.totalAppearances - team.totalWins, color: '#a34d5d' },
                            { title: 'Wins', value: team.totalWins, color: '#4da375' }
                        ]}
                        />
            </div>
            <div className="game-details-card">
                <h3>Games</h3>
                <GameDetailsCard teamName={team.teamName} game={team.gamesPlayed[0]}/>
            </div>
            {team.gamesPlayed.slice(1).map(game => <GameSmallCard key={game.id} teamName={team.teamName} game={game}/>)}
            <div>
                <Link className="more-link" to={`/teams/${teamName}/game/${years[0][0]}`}>More ></Link>
            </div>
        </div>
    );
}
