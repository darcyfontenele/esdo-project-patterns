import React from 'react'
import List from './List'
import MovieForm from './MovieForm'
import NavbarComponent from './Navbar'
import Rating from './Rating'
import {
  BrowserRouter as Router,
  Switch,
  Route
} from 'react-router-dom'

function App() {
  return (
    <Router>
      <NavbarComponent/>
      <Switch>
        <Route path="/movies">
          <List/>
        </Route>
        <Route path="/addMovie">
          <MovieForm/>
        </Route>
        <Route path="/ratingMovie">
          <Rating/>
        </Route>
      </Switch>
    </Router>
  );
}

export default App;