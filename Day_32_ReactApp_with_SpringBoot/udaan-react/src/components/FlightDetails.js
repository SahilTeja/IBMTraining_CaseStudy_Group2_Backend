import { Component } from "react";

export default class FlightDetails extends Component {
    constructor(props) {
        super(props);
    }

    onEdit() {
        this.props.onEdit();
    }

    render() {
        return (
            <table class="table table-bordered table-dark">
                <tr><td>Code</td><td>{this.props.flight.code}</td></tr>
                <tr><td>Carrier</td><td>{this.props.flight.carrier}</td></tr>
                <tr><td>Source</td><td>{this.props.flight.source}</td></tr>
                <tr><td>Destination</td><td>{this.props.flight.destination}</td></tr>
                <tr><td>Duration</td><td>{this.props.flight.duration}</td></tr>
                <tr><td>Price</td><td>{this.props.flight.price}</td></tr>
                <tr><td><button class="btn btn-info" onClick={() => this.onEdit()}>Edit</button></td>
                    <td><button class="btn btn-warning">Delete</button></td>
                </tr>
            </table>
        );
    }
} 