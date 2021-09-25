import { useRef } from "react";
import Card from "../ui/Card";
import styles from "./NewMeetupForm.module.css";

function NewMeetupForm(props){
    //Getting reference to each input on the form
    const titleInputRef = useRef();
    const imageInputRef = useRef();
    const addressInputRef = useRef();
    const descriptionInputRef = useRef();

    //After form is submitted...
    function submitFormHandler(event){
        event.preventDefault(); //We prevent react from sending http request which is default behavior for form
        //Grab the data from the references above
        const enteredTitle = titleInputRef.current.value;
        const enteredImage = imageInputRef.current.value;
        const enteredAddress = addressInputRef.current.value;
        const enteredDescription = descriptionInputRef.current.value;
        //Create meetupData array object to store our form information into one object to pass on
        const meetupData = {
            title: enteredTitle,
            image: enteredImage,
            address: enteredAddress,
            description: enteredDescription,
        };
        //Pass our meetup array data to a prop named onAddMeetup, which is actually a function that exists in the NewMeetups page that will run
        //once this form gets submitted
        props.onAddMeetup(meetupData);
    }


    return (
        <Card>
            <form className={styles.form} onSubmit={submitFormHandler}>
                <div className={styles.control}>
                    <label htmlFor="title">Meetup Title</label>
                    <input type="text" id="title" required ref={titleInputRef}/>
                </div>
                <div className={styles.control}>
                    <label htmlFor="image">Meetup Image</label>
                    <input type="url" id="image" required ref={imageInputRef} />
                </div>
                <div className={styles.control}>
                    <label htmlFor="address">Address</label>
                    <input type="text" id="address" required ref={addressInputRef} />
                </div>
                <div className={styles.control}>
                    <label htmlFor="description">Description</label>
                    <textarea id="description" rows='5' required ref={descriptionInputRef}></textarea>
                </div>
                <div className={styles.actions}>
                    <button>Add Meetup</button>
                </div>
            </form>
        </Card>
    );
}

export default NewMeetupForm;