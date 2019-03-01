import React from 'react';
import { Link } from 'react-router-dom'
//this.handleLogOut = this.handleLogOut.bind(this);

const Home = () => {

    return(
      <div>
          <h1>Home page</h1>
          <li><Link to='/hello'>Hello</Link></li>
      </div>
    );
};

export default Home;