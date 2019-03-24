import { authHeader } from '../header/auth_header.js';

let url = "http://localhost:8080";

export const userService = {
    login,
    logout,
    getAll
};

function login(email, password) {

    let myHeaders = new Headers();
    myHeaders.set("Content-Type", 'application/json');
    //myHeaders.append("Content-Type", 'charset=UTF-8');
    myHeaders.set("X-Requested-With", 'XMLHttpRequest');
    myHeaders.set("Authorization", "Basic " + btoa(email + ":" + password));

    const requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify({ email: email })
    };

    console.log(myHeaders);
    console.log(requestOptions);

    return fetch(url+'/login', requestOptions)
        .then(handleResponse)
        .then(user => {
            // login successful if there's a user in the response
            if (user) {
                // store user details and basic auth credentials in local storage
                // to keep user logged in between page refreshes
                const authdata = window.btoa(email + ':' + password);
                localStorage.setItem('authdata',JSON.stringify(user));
                localStorage.setItem('user', JSON.stringify(user));
            }
            return user;
        });
}

function logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('user');
    localStorage.removeItem('authdata');

    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };

    return fetch(url + '/logout', requestOptions).then(handleResponse);

}

function getAll() {
    const requestOptions = {
        method: 'GET',
        headers: authHeader()
    };

    return fetch(url + '/api/users', requestOptions).then(handleResponse);
}

function handleResponse(response) {
    return response.text().then(text => {
        const data = text && JSON.parse(text);
        if (!response.ok) {
            if (response.status === 401) {
                // auto logout if 401 response returned from api
                logout();
                //window.location.replace(url);
            }

            const error = (data && data.message) || response.statusText;
            return Promise.reject(error);
        }

        return data;
    });
}