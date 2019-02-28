import React from 'react'
import ReactDOM from 'react-dom'
import '../static/index.css'
import Form from './Form'

const inputs = [{
    name: "username",
    placeholder: "username",
    type: "text"
},{
    name: "password",
    placeholder: "password",
    type: "password"
},{
    type: "submit",
    value: "Submit",
    className: "btn"
}];

const props = {
    name: 'loginForm',
    method: 'POST',
    action: '/login',
    inputs: inputs
};

const params = new URLSearchParams(window.location.search);

ReactDOM.render(
    <Form {...props} error={params.get('error')} />,
    document.getElementById('container'));