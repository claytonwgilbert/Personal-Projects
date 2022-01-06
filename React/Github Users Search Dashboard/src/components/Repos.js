import React from 'react';
import styled from 'styled-components';
import { GithubContext } from '../context/context';
import { ExampleChart, Pie3D, Column3D, Bar3D, Doughnut2D } from './Charts';
const Repos = () => {
  const { repos } = React.useContext(GithubContext);
  
  //item=each item in repo, total=what we return
  const languages = repos.reduce((total, item)=>{
    //getting properties we need from repo item
    const { language, stargazers_count } = item;
    if(!language){//making sure we dont run into any null values or values we are not looking for, which we return nothing and move to next item
      return total;
    }
    if(!total[language]){//if first time seeing language, then create new property in our new object of that language
      total[language] = { label: language, value: 1, stars: stargazers_count }//create object to return
    }else{//otherwise update values of property
      total[language] = { ...total[language], value: total[language].value + 1, stars: total[language].stars + stargazers_count }//updating values of already existing object 
    }
    return total;
  },
  {} //what we are returning, an object, this is what total is referring to
  );

  //Object.values creates array of values stored in object passed in, here we sort to get highest stars values using sort and then returning only 5 max using slice
  const mostUsed = Object.values(languages).sort((a, b) => {
    return b.value - a.value;
  }).slice(0, 5);

  //same as mostUsed above, however we are sorting by most stars and also replacing the value property with the amount of stars, we have to do that because the chart will look at the value property of the object, so whatever we want to display in the chart needs to be a value to the value property, in this case we want to show stars, so the value needs to be stars for value property 
  const mostPopular = Object.values(languages).sort((a, b) => {
    return b.stars - a.stars;
  }).map((item) => {
    return {...item, value: item.stars}
  }).slice(0, 5);

  //here we are using the reduce to return a larger object that contains 2 properties, whose value is also an object
  let {stars, forks} = repos.reduce((total, item) => {
    const{stargazers_count, name, forks} = item; //getting properties we need
    total.stars[stargazers_count] = {label: name, value: stargazers_count} //creating object for our stars property containing the star count
    total.forks[forks] = {label: name, value: forks} //creating the forks object
    return total;
  }, { stars:{}, forks:{} }//what we are returning, what total refers to
  
  );

  //here we turn what was returned from reduce method into array of values and getting last 5 values as they are the largest and displaying largest first by using reverse() method
  stars = Object.values(stars).slice(-5).reverse();
  forks = Object.values(forks).slice(-5).reverse();

//dummy data
const chartData = [
  {
    label: "Javascript",
    value: "290"
  },
  {
    label: "HTML",
    value: "260"
  },
  {
    label: "CSS",
    value: "180"
  }
];

  return <section className='section'>
    <Wrapper className='section-center'>
      <Pie3D data={mostUsed} />
      <Column3D data={stars}/>
      <Doughnut2D data={mostPopular} />
      <Bar3D data={forks} />
    </Wrapper>
  </section>;
};

const Wrapper = styled.div`
  display: grid;
  justify-items: center;
  gap: 2rem;
  @media (min-width: 800px) {
    grid-template-columns: 1fr 1fr;
  }

  @media (min-width: 1200px) {
    grid-template-columns: 2fr 3fr;
  }

  div {
    width: 100% !important;
  }
  .fusioncharts-container {
    width: 100% !important;
  }
  svg {
    width: 100% !important;
    border-radius: var(--radius) !important;
  }
`;

export default Repos;
