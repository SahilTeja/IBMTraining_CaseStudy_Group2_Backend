import { Component } from 'react';

export default class Child extends Component {
    render(props) {
        return(
            <div>
                <h2>Hello from Child Component</h2>
                <h3>{this.props.greeting}</h3>
            </div>
        );
    }
}