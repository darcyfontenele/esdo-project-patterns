import { useState } from "react"
import { save } from "../api/movies"

export default () => {
  const [isCreated, setIsCreated] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const saveMovie = (movie) => {
    setIsLoading(true);

    const onSucess = () => {
      setIsLoading(false);
      setIsCreated(true);
    }

    const onError = (error) => {
      console.log(error);
      setIsLoading(false);
      setError({message: 'Unable to create movie.'})
    }

    save(onSucess, onError, movie);
  }

  return [isCreated, isLoading, error, saveMovie];
}