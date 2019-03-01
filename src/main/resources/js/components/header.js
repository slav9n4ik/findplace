import React from 'react';
import { Link } from 'react-router-dom'
//this.handleLogOut = this.handleLogOut.bind(this);

const Header = () => {

    return(
        <div>
            <h1>Header</h1>
            <li><Link to='/'>Home</Link></li>
            <li><Link to='/hello'>Hello</Link></li>
        </div>
    );
};

export default Header;