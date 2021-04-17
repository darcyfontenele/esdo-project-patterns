import React from 'react';
import {LoadingMessage, ErrorMessage} from './Utils'
import useListMovies from '../hooks/useListMovies'
import Table from 'react-bootstrap/Table'
import Button from 'react-bootstrap/Button'
import './List.css'

const Item = (props) => {
  const {movie} = props;

  const selectMovie = () => {
    console.log(movie)
    localStorage.setItem('selectedMovie', JSON.stringify(movie));
  }

  return (
    <tr>
      <td>{movie.id}</td>
      <td>{movie.title}</td>
      <td>{movie.synopsis}</td>
      <td>{movie.releaseYear}</td>
      <td>{movie.producerName}</td>
      <td>{movie.protagonistsName}</td>
      <td>{movie.averageRating !== "NaN" ? movie.averageRating.toFixed(1) : "-"}</td>
      <td><Button onClick={selectMovie} href="/ratingMovie">Rating</Button></td>
    </tr>
  );
}

const TableComponent = (props) => {
  const { movies } = props;
  return (
    <Table striped bordered hover className="mt-4 text-center">
      <thead>
        <tr>
          <th>#</th>
          <th>Title</th>
          <th>Synopsis</th>
          <th>Release Year</th>
          <th>Producer Name</th>
          <th>Protagonists Name</th>
          <th>Average Rating</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {
          movies.map(m => <Item key={m.id} movie={m}/>)
        }
      </tbody>
    </Table>
  );
}

const List = () => {
  const [movies, isLoading, error, fetchMovies] = useListMovies();
  localStorage.clear();
  return (
    <div className="d-flex flex-column justify-content-center align-items-center">
      {
        error ? <ErrorMessage message={error}/> :
        (isLoading ? <LoadingMessage/> : <TableComponent movies={movies}/>)
      }
      <Button onClick={fetchMovies} className="primary w-25 mt-2">Refresh</Button>
    </div>
  );
}

export default List;