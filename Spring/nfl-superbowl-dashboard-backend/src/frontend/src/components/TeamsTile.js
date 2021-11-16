import { React } from 'react';
import './TeamsTile.scss';
import { Link } from 'react-router-dom';

export const TeamsTile = ({teamName}) => {
    return (
        <div className="TeamsTile">
            <Link to={`/teams/${teamName}`}><h1>{teamName}</h1></Link>
        </div>
    )
}