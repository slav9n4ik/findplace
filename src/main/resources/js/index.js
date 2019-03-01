import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Header from './components/header.js';
import Login from './login.js';
import Home from './components/home.js';
import Hello from './components/hello.js';

ReactDOM.render(
    <BrowserRouter>
        <div>
        <Header />
            <Switch>
                <Route exact path="/" component={Home} />
                <Route path="/hello" component={Hello} />
                {/*<Route path="/login" component={Login} />*/}
            </Switch>
        </div>
    </BrowserRouter>,
    document.getElementById('container'));