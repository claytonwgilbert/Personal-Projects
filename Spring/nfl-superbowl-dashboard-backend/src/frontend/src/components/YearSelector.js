import { React } from 'react';
import { Link } from 'react-router-dom';
import './YearSelector.scss';

export const YearSelector = ({team}) => {

    let teamName = team.teamName;
    let dates = team.gamesPlayed;
    let years = dates.map(date => date.sbDate.split('-'));

    return(
        <ol className="YearSelector">
            {
                years.map(year => (
                <li>
                    <Link to={`/teams/${teamName}/game/${year[0]}`}>{year[0]}</Link>
                </li>
            ))
            }
        </ol>
    )
}