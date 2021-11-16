import { React, useEffect, useState } from 'react';
import { TeamsTile } from '../components/TeamsTile';
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
                {teams.map(team => <TeamsTile key={team.id} teamName={team.teamName}/>)}
            </div> 
        </div>
    );
}