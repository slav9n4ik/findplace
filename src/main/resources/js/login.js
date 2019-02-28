import React from 'react'
import '../static/index.css'
import Form from './components/form'

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

const Login = () => {
    return (
        <div>
            <Form {...props} error={params.get('error')}/>
        </div>
    )
};

export default Login;

