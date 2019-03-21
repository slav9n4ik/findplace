import React from 'react';
import ReactDOM from 'react-dom';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import Header from './js/components/header.js';
import Home from './js/components/home.js';
import Profile from './js/components/profile.js';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(
    <BrowserRouter>
        <div>
        <Header />
            <Switch>
                <Route exact path="/" component={Home} />
                <Route path="/profile" component={Profile} />
            </Switch>
        </div>
    </BrowserRouter>,
    document.getElementById('root'));
registerServiceWorker();