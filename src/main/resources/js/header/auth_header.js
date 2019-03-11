export function authHeader() {
    // return authorization header with basic auth credentials
    let user = JSON.parse(localStorage.getItem('authdata'));

    if (user && user.authdata) {
        return { 'Authorization': 'Basic ' + user.authdata };
    } else {
        return {};
    }
}