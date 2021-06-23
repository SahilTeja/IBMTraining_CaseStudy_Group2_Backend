import { Component } from 'react';

class Show extends Component {
    render(props) {
        return (
            <h1> Hello from Class Component, designed by {this.props.author || 'John'} </h1>
        );   // it is used to provide default value to author   || 'John'
        
    }
}

export default Show