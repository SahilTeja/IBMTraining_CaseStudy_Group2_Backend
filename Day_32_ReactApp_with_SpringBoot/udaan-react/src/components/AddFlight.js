import { Component } from "react";

export default class AddFlight extends Component {
    constructor(props) {
        super(props);
        this.state = {
            code:0,
            carrier:'',
            source:'',
            destination:'',
            duration:'',
            price:0
        }
    }

    handleInput = (event) => {
        const name = event.target.name;
        const value = event.target.value;
        this.setState({
            [name]:value
        });
    }

    render() {
        return(
            <table class = "table table-dark">
                <tr>
                    <td>Code</td>
                    <td><input name="code" value={this.state.code} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td>Carrier</td>
                    <td><input name="carrier" value={this.state.carrier} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td>Source</td>
                    <td><input name="source" value={this.state.source} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td>Destination</td>
                    <td><input name="destination" value={this.state.destination} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td>Duration</td>
                    <td><input name="duration" value={this.state.duration} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td>Price</td>
                    <td><input name="price" value={this.state.price} onChange={this.handleInput} /></td>
                </tr>
                <tr>
                    <td><button class="btn btn-info">Save Flight</button></td>
                    <td><button class="btn btn-warning">Cancel Flight</button></td>
                </tr>
            </table>
        );
    }
}