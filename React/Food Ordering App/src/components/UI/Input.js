import styles from './Input.module.css';


function Input(props){
    return <div className={styles.input}>
        <label htmlFor={props.input.id}>{props.label}</label>
        <input {...props.input} />
    </div>
    //This ...props.input spread operator will take every attribute like id or type on an input being passed in and copies
    //all of those attributes onto this input as attributes.
};

export default Input;