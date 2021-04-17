import React from 'react'

export const LoadingMessage = () => {
  return (
    <p>Loading...</p>
  );
}

export const ErrorMessage = (props) => {
  const {error} = props;
  return (
    <h3>{error.message}</h3>
  );
}