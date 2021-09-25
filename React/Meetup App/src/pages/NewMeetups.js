import { useHistory } from "react-router";
import NewMeetupForm from "../components/meetups/NewMeetupForm";

function NewMeetupsPage() {
    //History hook...
    const history = useHistory();

    function addMeetupHandler(meetupData){
        //Posting our new meetup data from our form that was passed from the NewMeetupForm
        fetch(
            'https://react-meetup-project-dbc7f-default-rtdb.firebaseio.com/meetups.json',
            {
                method: 'POST',
                body: JSON.stringify(meetupData),
                headers: {
                    'Content-Type': 'application/json'
                }
            } 
        ).then(() => {
            //This history hook allows us to navigate away from the form page after a submit, in this case back to home.
            history.replace('/');
        });
    }
    return (
    <section>
        <h1>Add New Meetup</h1>
        <NewMeetupForm onAddMeetup={addMeetupHandler} /> 
    </section> //Here we add a property name and add a function name as the value, this function will live on the components side and will run there
    )
}
export default NewMeetupsPage;