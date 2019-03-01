import React from 'react';
import { Switch, Route } from 'react-router-dom'
import Login from '../login.js';
import Home from './home.js';
import Hello from './hello.js';


const Main = () => {
    return (
        <div>
        <Switch>
            <Route path='/' component={Home}/>
            <Route path='/login' component={Login}/>
            <Route path='/hello' component={Hello}/>
        </Switch>
        </div>
    );
};

export default Main;