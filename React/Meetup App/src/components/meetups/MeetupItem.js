import { useContext } from 'react';
import FavoritesContext from '../../store/favorites-context';
import Card from '../ui/Card';
import styles from './MeetupItem.module.css';

function MeetupItem(props) { //Creating a meetupitem from data passed from meetuplist component

    const favContext = useContext(FavoritesContext);

    const itemIsFavorite = favContext.itemIsFavorite(props.id);

    function toggleFavoriteStatusHandler(){
        if(itemIsFavorite){
            favContext.removeFavorite(props.id);
        }else{
            favContext.addFavorite({
                id: props.id,
                title: props.title,
                image: props.image,
                description: props.description,
                address: props.address
            });
        }
    }

    return (
        <li className={styles.item}>
            <Card>
                <div className={styles.image}>
                    <img src={props.image} alt={props.title} />
                </div>
                <div className={styles.content}>
                    <h3>{props.title}</h3>
                    <address>{props.address}</address>
                    <p>{props.description}</p>
                </div>
                <div className={styles.actions}>
                    <button onClick={toggleFavoriteStatusHandler}>{itemIsFavorite ? 'Remove from Favorites' : 'To Favorites'}</button>
                </div>
            </Card>
        </li>
    );
}
export default MeetupItem;