import { Fragment } from "react";
import mealsImage from '../../assets/meals.jpg';
import styles from './Header.module.css';
import HeaderCartButton from "./HeaderCartButton";

function Header(props){
    return <Fragment>
        <header className={styles.header}>
            <h1>Meals React!</h1>
            <HeaderCartButton onClick={props.onShowCart} />
        </header>
        <div className={styles['main-image']}>
            <img src={mealsImage} alt="A table full of different foods"/>
        </div>
    </Fragment>
};

export default Header;