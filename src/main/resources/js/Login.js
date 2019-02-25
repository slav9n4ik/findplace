import React,{Component} from 'react';
import ReactDOM from 'react-dom';
import Form from './Form.js';

class LoginPage extends Component {
    constructor(props) {
        super(props);
        this.state = {};
    }

    render() {
        return(
            <Form/>
        );
    }
}
ReactDOM.render(
    <App />,
    document.getElementById('login')
);