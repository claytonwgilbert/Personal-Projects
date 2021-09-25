import { Route, Switch } from "react-router";
import Layout from "./components/layouts/Layout";
import AllMeetupsPage from "./pages/AllMeetups";
import FavoriteMeetupsPage from "./pages/Favorites";
import NewMeetupsPage from "./pages/NewMeetups";

function App() {
  return <div>
    <Layout>
      <Switch>
        <Route path='/' exact>
          <AllMeetupsPage />
        </Route>
        <Route path='/new-meetup'>       
          <NewMeetupsPage />
        </Route>
        <Route path='/favorites'>
          <FavoriteMeetupsPage />
        </Route>
      </Switch>
    </Layout>
  </div>;

}

export default App;
