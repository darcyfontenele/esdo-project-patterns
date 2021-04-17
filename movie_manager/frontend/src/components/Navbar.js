import React from 'react'
import Navbar from 'react-bootstrap/Navbar'
import Nav from 'react-bootstrap/Nav'
import NavDropdown from 'react-bootstrap/NavDropdown'

const NavbarComponent = () => {
  return (
    <Navbar bg="light" expand="lg">
      <Navbar.Brand>Movie Appraiser</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <NavDropdown title="Movie" id="basic-nav-dropdown">
            <NavDropdown.Item className="text-center" href="/movies">List</NavDropdown.Item>
            <NavDropdown.Item className="text-center" href="/addMovie">Add</NavDropdown.Item>
          </NavDropdown>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default NavbarComponent;