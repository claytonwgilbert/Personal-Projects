import axios from './axios'
import { useEffect, useState } from 'react'
import './Banner.css'
import requests from './Requests'

const Banner = () => {
    const [movie, setMovie] = useState([])

    useEffect(() => {
        const fetchData = async () => {
            const request = await axios.get(requests.fetchNetflixOriginals)
            setMovie(
                request.data.results[ //set movie to random movie from array of results
                    Math.floor(Math.random() * request.data.results.length - 1)
                ]
            )
            return request
        }
        fetchData()
    }, [])

    console.log(movie);

    function truncateText(string, n){
        return string?.length > n ? string.substr(0, n-1) + '...' : string
    }

    return (
            <header className='banner' style={
                { 
                    backgroundSize: "cover", 
                    backgroundImage: `url('https://image.tmdb.org/t/p/original/${movie?.backdrop_path}')`,
                    backgroundPosition: "center center",
                }
            }>
            <div className='banner_contents'>
                <h1 className='banner_title'>
                    {movie?.title || movie?.name || movie?.original_name}
                </h1>
                <div className='banner_buttons'>
                    <button className='banner_button'>Play</button>
                    <button className='banner_button'>My List</button>
                </div>
                <div className='banner_description'>
                    {truncateText(movie?.overview, 150)}
                </div>
            </div> 
            <div className='banner--fadeBottom' />                                  
            </header>
    )
}

export default Banner
