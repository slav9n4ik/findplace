import React, {Component} from 'react';
import Header from './header.js';
import {BrowserRouter, Route, Switch} from "react-router-dom";
import Home from "./home";
import Hello from "./hello";

class App extends Component{
    constructor(props) {
        super(props);
    }

    //Сделать прайвет роут чтобы не было доступа к другим ссылкам и хедеру

    render() {
        return (
            <BrowserRouter>
                <div>
                    <Header />
                    <Switch>
                        <Route path='/' component={Home}/>
                        <Route path='/hello' component={Hello}/>
                    </Switch>
                </div>
            </BrowserRouter>
        )
    }
}

export default App;