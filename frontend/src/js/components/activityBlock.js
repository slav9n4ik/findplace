import React from 'react';

const ActivityBlock = (props) => {

    return (
        <div className="col">
            <div className="alert alert-info" role="alert">
                {props.name}
            </div>
        </div>
        
    );
}

export default ActivityBlock;