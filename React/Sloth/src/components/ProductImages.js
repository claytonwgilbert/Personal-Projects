import React, { useState } from 'react'
import styled from 'styled-components'

const ProductImages = ({ images = [{ url:''}] }) => { //setting image array to default of empty as well as url property as they are initially undefined until loaded in and when we attempt access to array or prperties such as url on undefined object, it will blow up, setting them to a default of empty will prevent the program from blowing up when we attempt to access the properties
  const [ main, setMain ] = useState(images[0]) //first image in array set to main image

  return <Wrapper>
    <img src={main.url} alt='main image' className='main'/>
    <div className='gallery'>
      {
      images.map((image, index) => {
        return <img 
                  key={index} 
                  src={image.url} 
                  alt={image.filename} 
                  onClick={() => setMain(images[index])} 
                  className={`${image.url === main.url ? 'active' : null }`}/>
      })
      }
    </div>
  </Wrapper>
}

const Wrapper = styled.section`
  .main {
    height: 600px;
  }
  img {
    width: 100%;
    display: block;
    border-radius: var(--radius);
    object-fit: cover;
  }
  .gallery {
    margin-top: 1rem;
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    column-gap: 1rem;
    img {
      height: 100px;
      cursor: pointer;
    }
  }
  .active {
    box-shadow: 0px 0px 0px 2px var(--clr-primary-5);
  }
  @media (max-width: 576px) {
    .main {
      height: 300px;
    }
    .gallery {
      img {
        height: 50px;
      }
    }
  }
  @media (min-width: 992px) {
    .main {
      height: 500px;
    }
    .gallery {
      img {
        height: 75px;
      }
    }
  }
`

export default ProductImages
