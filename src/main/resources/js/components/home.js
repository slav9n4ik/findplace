import React,{Component} from 'react';
import { Link } from 'react-router-dom'

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            showOwner: ""
        };
        // this.showInfo = this.showInfo.bind(this);
    }

    render() {
        const showInfo = (event) => {
            event.preventDefault();
            fetch('/api/owner', {
                method: 'GET',
                headers:{"X-Requested-With": 'XMLHttpRequest'}
            })
                .then(v => {
                    console.log("Data from api: " + v.data);
                    this.setState(
                        {showOwner: v.data}
                    );
                })
                .catch(e => console.warn(e))

        };

        return (
            <div>
                <h1>Home page</h1>
                <li><Link to='/hello'>Hello</Link></li>
                <input
                    type="button"
                    onClick={showInfo}
                    value="Show owner info"
                />
                <h1> {this.state.showOwner}</h1>
            </div>
        );
    };
}

export default Home;