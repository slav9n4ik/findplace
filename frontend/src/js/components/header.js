import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import IconLogo from '../../static/icon.png'
import IconUser from '../../static/user.png'

const Header = () => {
    return(
        <div>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
            <img src={IconLogo} width="50" height="50" className="d-inline-block align-top" alt=""/>
                <a className="navbar-brand" style={{color: "blue"}} href="/">FindPlace</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div className="navbar-nav mr-auto">
                        <a className="nav-item nav-link active" href="/">Главная <span className="sr-only">(current)</span></a>
                        <a className="nav-item nav-link" href="/activityList">Список</a>
                    </div>
                    <div>                        
                        <img src={IconUser} width="40" height="40" className="d-inline-block align-top" alt=""/>
                        <a className="navbar-text ml-2" href="/profile">Профиль</a>               
                    </div>
                    
                </div>
                </nav>
        </div>
    );
};

export default Header;