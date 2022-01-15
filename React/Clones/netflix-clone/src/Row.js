import { useEffect, useState } from 'react'
import './Row.css'
import axios from './axios'

const Row = ({title, fetchUrl, isLargeRow = false}) => {
    const [movies, setMovies] = useState([])
    const baseUrl = 'https://image.tmdb.org/t/p/original/'
    
    useEffect(() => {
        const fetchMovies = async () => {
            const request = await axios.get(fetchUrl)
            setMovies(request.data.results)
            return request
        }
        fetchMovies()
    }, [fetchUrl])
    
    return (
        <div className='row'>
            <h2>{title}</h2>
                <div className='row_posters'>
                    {
                        movies.map((movie) => {
                        return (
                           <img key={movie.id} 
                                className={`row_poster ${isLargeRow && 'row_posterLarge'}`} 
                                src={`${baseUrl}${isLargeRow ? movie.poster_path : movie.backdrop_path}`} 
                                alt={movie.name}/>
                            )
                        }) 
                    }
                </div>
        </div>
    )
}

export default Row
