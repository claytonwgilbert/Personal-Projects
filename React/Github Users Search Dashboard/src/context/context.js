import React, { useState, useEffect } from 'react';
import mockUser from './mockData.js/mockUser';
import mockRepos from './mockData.js/mockRepos';
import mockFollowers from './mockData.js/mockFollowers';
import axios from 'axios';

const rootUrl = 'https://api.github.com';

const GithubContext = React.createContext();

const GithubProvider = ({children}) => {
    const [githubUser, setGithubUser] = useState(mockUser);
    const [repos, setRepos] = useState(mockRepos);
    const [followers, setFollowers] = useState(mockFollowers);
    const [requests, setRequests] = useState(0);
    const [isLoading, setIsLoading] = useState(false);
    const [error, setError] = useState({show:false, msg:""});
    
    const searchGithubUser = async(user) => {
        toggleError(); //toggle error, which when not passing anything, sets default values to false and no error
        setIsLoading(true);
        const response = await axios(`${rootUrl}/users/${user}`).catch((err) => {
            console.log(err);
        });
        if(response){ //if we have a user response
            console.log(response);
            setGithubUser(response.data);
            const { repos_url, followers_url } = response.data; //grab data we need
            //make calls needed to update rest of application
            axios(`${repos_url}?per_page=100`).then((response) => {
                setRepos(response.data);
            });
            axios(`${followers_url}?per_page=100`).then((response) => {
                setFollowers(response.data);
            });
        }else{
            toggleError(true, 'sorry, no user by that username found...');
        }
        checkRequests(); //check requests limit to make sure we havent ran past quota
        setIsLoading(false);
    }

    const checkRequests = () => {
        axios(`${rootUrl}/rate_limit`)
        .then(({ data }) => {
            let { rate: { remaining },} = data; //get the data property we need for logic
            //same as accessing it with rate.remaining = data;
         setRequests(remaining);
         if(remaining === 0){
            toggleError(true, 'sorry, you have exceeded your hourly request limit');
         }
        })
        .catch((err) => {
            console.log(err);
        })
    };

    // = means setting default values
    function toggleError(show = false, msg = ''){
        setError({show, msg});
    }

    //not passing in arrow function means this function runs each time application is reloaded
    useEffect(checkRequests, []);

    return <GithubContext.Provider value={{githubUser, repos, followers, requests, error, searchGithubUser, isLoading}}>{children}</GithubContext.Provider>
}

export {GithubProvider, GithubContext};