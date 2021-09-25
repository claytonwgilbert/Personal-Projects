import styles from './Card.module.css';

function Card(props) {
    return (
        <div className={styles.card}>
            {props.children} 
        </div>
    );
}

export default Card;

//{props.children} spits out all the jsx data that exists between wherever this Card component is being used,
//this way we can use this component as a style wrapper and if we didn't use props.children, all the jsx content that
//sat between this Card component would have just been erased and replaced with whatever jsx is in the component itself
//Example:
//<Card>
//  <div> <---Doesn't get erased
//      <h1>Data</h1> <---
//  </div> <---
//</Card>