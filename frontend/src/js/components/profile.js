import React, {Component} from 'react';
import IconUser from '../../static/user.png';
import ActivityBlock from './activityBlock.js';

let url = "http://localhost:8080";

class Profile extends Component {
    constructor() {
        super();
        this.state ={
            apiData: [],
            isLoading: false,
            error: null
        };        
    }

componentDidMount() {
    this.setState({
        isLoading : true
    });

    const requestOptions = {
        method: 'GET',
        headers: {"Authorization":"Basic c2xhdmFAc3MucnU6MTIz"}
    };

    console.log("Activities fetch",requestOptions);
    fetch(url + '/api/interests', requestOptions)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Activities not load ...');
            }
        })
            .then(data => {
                console.log("Activities response result: ", data)
                const activityList = data.data;
                console.log("Activities result parse: ", activityList);
                this.setState({
                    apiData : activityList,
                    isLoading : false
                });
            })
        .catch(error => this.setState({ error, isLoading: false }));
    }

    render() {
        const { apiData, isLoading, error} = this.state;

        if (error) {
            return <p>{error.message}</p>;
          }

        if (isLoading) {
            return <p>Loading ...</p>;
        }
        
        let ActivityBlockComponents = apiData.map((item) => {
            return(
                <div className="row justify-content-md-center">
                    <ActivityBlock key={item.interest_id} 
                                   name={item.name} 
                    />
                </div>
            );
        });

        return(
            <div className="container mt-4">
                <div className="row">
                    <div className="col text-right">
                        <img src={IconUser} width="200" height="200" className="d-inline-block align-top" alt=""/>
                    </div>
                    <div className="col">
                        <form className="mt-4">
                        <div className="row ">
                            <div className="form-group ">
                                <input type="text" className="form-control" style={{textAlign: "center"}} id="UserName" value="UserName"/>
                            </div> 
                        </div>   
                        <div className="row ">
                            <div className="form-group ">
                                <input type="text" className="form-control" style={{textAlign: "center"}} id="UserPhone" value="8 (800) 555-55-35"/>
                            </div> 
                        </div>
                        <div className="row ">
                            <div className="form-group ">
                                <input type="text" className="form-control" style={{textAlign: "center"}} id="UserEmail" value="mySuperEmail@youyou.com"/>
                            </div> 
                        </div>
                    </form>
                    </div>
                </div>
                
                {ActivityBlockComponents}                                  

            </div>
        );
    }
}

export default Profile;