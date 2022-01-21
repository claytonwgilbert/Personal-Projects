import React from 'react'
import styled from 'styled-components'
import { PageHero } from '../components'
import aboutImg from '../assets/hero-bcg.jpeg'

const AboutPage = () => {
  return <main>
    <PageHero title="About" />
    <Wrapper className='page section section-center'>
        <img src={aboutImg} alt='nice desk'/>
        <article>
          <div className='title'>
            <h2>our story</h2>
            <div className='underline'></div>
          </div>
          <p>
            Fugiat et eu consequat exercitation magna enim ut Lorem veniam incididunt aute Lorem aute adipisicing. 
            Cillum laboris culpa adipisicing enim Lorem aliquip proident eu enim ea reprehenderit laboris. 
            Nulla ea aliquip ex sint consequat proident. Reprehenderit do amet non aliqua cillum qui et est fugiat ea. 
            Do do aliquip ut laborum irure ipsum et excepteur dolor culpa duis elit. 
            Anim et officia labore irure est cupidatat ea laborum veniam consequat.
          </p>
        </article>
    </Wrapper>
  </main>
}

const Wrapper = styled.section`
  display: grid;
  gap: 4rem;
  img {
    width: 100%;
    display: block;
    border-radius: var(--radius);
    height: 500px;
    object-fit: cover;
  }
  p {
    line-height: 2;
    max-width: 45em;
    margin: 0 auto;
    margin-top: 2rem;
    color: var(--clr-grey-5);
  }
  .title {
    text-align: left;
  }
  .underline {
    margin-left: 0;
  }
  @media (min-width: 992px) {
    grid-template-columns: 1fr 1fr;
  }
`
export default AboutPage
