import { useState } from "react"
import { saveRating } from "../api/movieRatings"

export default () => {
  const [isRated, setIsRated] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState(null);

  const ratingMovie = (rating) => {
    setIsLoading(true);

    const onSucess = () => {
      setIsLoading(false);
      setIsRated(true);
    }

    const onError = (error) => {
      console.log(error);
      setIsLoading(false);
      setError({message: 'Unable to rating movie.'})
    }

    saveRating(onSucess, onError, rating);
  }

  return [isRated, isLoading, error, ratingMovie];
}