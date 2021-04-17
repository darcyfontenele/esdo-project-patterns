import React from 'react'
import { useState } from 'react'
import { Redirect } from 'react-router-dom'
import {LoadingMessage, ErrorMessage} from './Utils'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import useRatingForm from '../hooks/useRatingForm'

function fillMovie() {
  let restoredMovie = JSON.parse(localStorage.getItem("selectedMovie"));
  if(!restoredMovie)
    return <Redirect to="/movies"/>
  return restoredMovie;
}

const RatingForm = () => {

  const [isRated, isLoading, error, ratingMovie] = useRatingForm();

  const [rating, setRating] = useState({
    movie: fillMovie()
  });

  const handleSubmit = (event) => {
    event.preventDefault();
    ratingMovie(rating);
  };

  const changeEventHandle = (event) => {
    let nam = event.target.name;
    let val = event.target.value;
    setRating({...rating, [nam]: val});
  }

  if (isRated) {
    return <Redirect to='/movies'/>;
  }

  return (
    <div className="d-flex flex-column align-items-center">
      <h3 className="mt-3">Rating Movie</h3>
      { error ? <ErrorMessage error={error}/> : (isLoading ? <LoadingMessage/> :
        <Form className="d-flex flex-column mt-2 w-75 align-items-center" onSubmit={handleSubmit}>
          <div className="w-100">
            <Form.Group controlId="formAppraisersName">
              <Form.Label>Appraisers Name</Form.Label>
              <Form.Control type="text" name="appraisersName" onChange={changeEventHandle} placeholder="Enter your name"/>
            </Form.Group>

            <Form.Group controlId="formRating">
              <Form.Label>Rating</Form.Label>
              <Form.Control type="text" pattern="[0-5]{1}" placeholder="Enter your rating" name="rating" onChange={changeEventHandle}/>
            </Form.Group>

            <Form.Group controlId="formProducerName">
              <Form.Label>Movie Title</Form.Label>
              <Form.Control disabled={true} type="text" placeholder="Enter producer name" value={rating.movie.title}/>
            </Form.Group>
          </div>
          <div>
            <Button variant="primary" type="submit">Submit</Button>
          </div>
        </Form>
      )}
    </div>
  );
}

export default RatingForm;