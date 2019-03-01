import React from 'react';

const Hello = () => {

    const handleLogOut = (event) => {
        event.preventDefault();
        fetch('/logout', {
            method: 'POST',
            body: ''
        })
            .then(v => {
                if (v.redirected) window.location = v.url
            })
            .catch(e => console.warn(e))

    };

    return(
        <div>
            <h1>Hello page</h1>
            <form action="/logout" method="post">
                <input
                    type="submit"
                    value="Logout"
                />
            </form>
        </div>
    );
};

export default Hello;