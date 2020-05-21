import { useEffect, useState } from "react";
import { findAll } from "../api/movies";

export default () => {
  const [movies, setMovies] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const fetchMovies = () => {
    setIsLoading(true);

    const onSucess = (response) => {
      setIsLoading(false);
      setMovies(response.data)
    }

    const onError = (error) => {
      console.log(error);
      setIsLoading(false);
      setError({message: 'Unable to load all movies.'})
    }

    findAll(onSucess, onError);
  }

  useEffect(() => fetchMovies(), []);

  return [movies, isLoading, error, fetchMovies];
}