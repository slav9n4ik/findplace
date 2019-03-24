import React from 'react';

const Hello = () => {

    const handleLogOut = (event) => {
        event.preventDefault();
        fetch('/logout', {
            method: 'GET',
            headers:{"X-Requested-With": 'XMLHttpRequest'}
        })
            .then(v => {
                window.location.replace("/login");
            })
            .catch(e => console.warn(e))

    };

    return(
        <div>
            <h1>Hello page</h1>
                <input
                    type="button"
                    onClick={handleLogOut}
                    value="Logout"
                />
        </div>
    );
};

export default Hello;