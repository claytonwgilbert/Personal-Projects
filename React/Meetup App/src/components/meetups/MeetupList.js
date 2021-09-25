import MeetupItem from './MeetupItem';
import styles from './MeetupList.module.css';

//We receive the meetups from the AllMeetups page which is in our props variable.
function MeetupList(props) {
    return (
    <ul className={styles.list}>
        {props.meetups.map(meetup => <MeetupItem  //Translate each meetup into a meetupitem component
                                        key={meetup.id} 
                                        id={meetup.id} 
                                        image={meetup.image}
                                        title={meetup.title}
                                        address={meetup.address}
                                        description={meetup.description}/>)}
    </ul>
);
}
export default MeetupList;