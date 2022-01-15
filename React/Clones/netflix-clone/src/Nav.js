import { useEffect, useState } from 'react';
import './Nav.css';

const Nav = () => {
    const [show, setShow] = useState(false)

    const transitionNavbar = () => {
        if(window.scrollY > 100){
            setShow(true)
        }else{
            setShow(false)
        }
    }

    useEffect(() => {
        window.addEventListener("scroll", transitionNavbar)
        return () => {
            window.removeEventListener("scroll", transitionNavbar)
        }
    }, [])



    return (
        <div className={`nav ${show && 'nav_black'}`}>
            <div className='nav_contents'>
                <img className='nav_logo'
                    src="http://assets.stickpng.com/images/580b57fcd9996e24bc43c529.png" 
                    alt="logo" />
                
                <img className='nav_avatar'
                    src="https://ih0.redbubble.net/image.618427277.3222/flat,1000x1000,075,f.u2.jpg" 
                    alt="logo" />
            </div>
        </div>


    )
}

export default Nav
