import { useEffect, useState } from "react";
import MeetupList from "../components/meetups/MeetupList";

function AllMeetupsPage() {
  const [isLoading, setIsLoading] = useState(true);
  const [loadedMeetups, setLoadedMeetups] = useState([]);

  useEffect(() => {
    //Getting the data from firebase
    fetch(
      "https://react-meetup-project-dbc7f-default-rtdb.firebaseio.com/meetups.json"
    )
      .then((response) => {
        return response.json(); //converting data from firebase to JSON
      })
      .then((data) => {
        const meetups = []; //Array we will store the data we parse in the next step in
        for(const key in data){
            const meetup = {
                id: key,
                ...data[key] //...spread operator that copies all key value pairs within each object and creates new object that will go in our meetups array.
            }
            meetups.push(meetup);
        }
        setIsLoading(false); //Change state so that we don't display loading text anymore
        setLoadedMeetups(meetups); //Change state again and pass in our now parsed data to the state so that we can display all the data
      });
  }, []); //We use the useEffect with an empty array as argument to prevent the page from looping over infinitely. useEffect runs after every render of the component when no arguments are passed but when you pass an empty array as second argument, react will use that array to see what changes have occured, and since its an empty array, nothing changes and react will not run the useEffect method after the one initial time since nothing ever changes. We do this to prevent infinite looping of our data.

  //When our state is loading, we display the is loading text while we get the data...
  if (isLoading) {
    return (
      <section>
        <p>Loading...</p>
      </section>
    );
  }
  //We finally return a div containing our MeetupList component and we pass to the component our data we stored in our loadedmeetups state array.
  return (
    <div>
      <h1>All meetups!</h1>
      <MeetupList meetups={loadedMeetups} />
    </div>
  );
}
export default AllMeetupsPage;
