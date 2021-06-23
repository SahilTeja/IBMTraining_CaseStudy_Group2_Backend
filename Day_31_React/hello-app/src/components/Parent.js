import { Component } from 'react';
import Child from './Child';

export default class Parent extends Component {
    render() {
        return(
            <div>
                <h1>Hello from Parent Component</h1>
                <Child greeting="Hello from parent to child" />
            </div>
        );
    }
}