import { React, useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { GameDetailsCard } from '../components/GameDetailsCard';
import { TeamsTile } from '../components/TeamsTile';
import { YearSelector } from '../components/YearSelector';
import './HomePage.scss';

export const HomePage = () => {

    const [teams, setTeams] = useState([]);

    useEffect(
        () => {
            const getAllTeams = async () => {
                const response = await fetch(`http://localhost:8080/teams`);
                const data = await response.json();
                setTeams(data);
            };
            getAllTeams();

        }, []
    );

    if(!teams){
        return <h1>Loading...</h1>
    }

    return (
        <div className="HomePage">
            <div className="header-section">
                <h1 className="header-name">Superbowl History Dashboard</h1>
            </div>
            <div className="team-grid">
                {teams.map(team => <TeamsTile teamName={team.teamName}/>)}
            </div> 
        </div>
    );
}