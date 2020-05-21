import axios from 'axios';

export const findAll = (onSucess, onError) => {
  axios.get('http://localhost:8080/movies')
    .then(onSucess)
    .catch(onError);
}

export const save = (onSucess, onError, movie) => {
  axios.post('http://localhost:8080/movies', movie)
    .then(onSucess)
    .catch(onError);
}