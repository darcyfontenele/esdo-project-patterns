import axios from 'axios'

export const saveRating = (onSucess, onError, rating) => {
  axios.post('http://localhost:8080/movieRatings', rating)
    .then(onSucess)
    .catch(onError);
}