import React, {Component} from 'react';
import Main from './main.js';
import Header from './header.js';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Home from "./home";
import Login from "../login";
import Hello from "./hello";

class App extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <BrowserRouter>
                <div>
                    <Header />
                    <Switch>
                        <Route path='/' component={Home}/>
                        <Route path='/login' component={Login}/>
                        <Route path='/hello' component={Hello}/>
                    </Switch>
                </div>
            </BrowserRouter>
        )
    }
}

export default App;