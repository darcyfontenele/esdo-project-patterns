import React from 'react'
import { useState } from "react";
import {LoadingMessage, ErrorMessage} from './Utils'
import useMovieForm from '../hooks/useMovieForm'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import { Redirect } from 'react-router-dom'

const MovieForm = () => {
  
  const [movie, setMovie] = useState(null);
  
  const [isCreated, isLoading, error, saveMovie] = useMovieForm();
  
  const handleSubmit = (event) => {
    event.preventDefault();
    saveMovie(movie);
  };

  const changeEventHandle = (event) => {
    let nam = event.target.name;
    let val = event.target.value;
    setMovie({...movie, [nam]: val});
  }

  if (isCreated) {
    return <Redirect to='/movies'/>;
  }

  return (
    <div className="d-flex flex-column align-items-center">
      <h3 className="mt-3">Add Movie</h3>
      { error ? <ErrorMessage error={error}/> : (isLoading ? <LoadingMessage/> :
        <Form className="d-flex flex-column mt-2 w-75 align-items-center" onSubmit={handleSubmit}>
          <div className="w-100">
            <Form.Group controlId="formTitle">
              <Form.Label>Title</Form.Label>
              <Form.Control type="text" name="title" onChange={changeEventHandle} placeholder="Enter movie title"/>
            </Form.Group>

            <Form.Group controlId="formSynopsy">
              <Form.Label>Synopsis</Form.Label>
              <Form.Control as="textarea" rows="2" placeholder="Enter synopsis" name="synopsis" onChange={changeEventHandle}/>
            </Form.Group>

            <Form.Group controlId="formReleaseYear">
              <Form.Label>Release Year</Form.Label>
              <Form.Control type="text" pattern="[0-9]{4}" placeholder="Enter release year" name="releaseYear" onChange={changeEventHandle}/>
            </Form.Group>

            <Form.Group controlId="formProducerName">
              <Form.Label>Producer Name</Form.Label>
              <Form.Control type="text" placeholder="Enter producer name" name="producerName" onChange={changeEventHandle}/>
            </Form.Group>

            <Form.Group controlId="formProtagonistsName">
              <Form.Label>Protagonists Name</Form.Label>
              <Form.Control type="text" placeholder="Enter protaganists name" name="protagonistsName" onChange={changeEventHandle}/>
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

export default MovieForm;