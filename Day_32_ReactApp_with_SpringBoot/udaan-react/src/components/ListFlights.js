import { Component } from "react";
import FlightService from "../services/FlightService";
import FlightDetails from "./FlightDetails";
import AddFlight from "./AddFlight";
import EditFlight from "./EditFlight";

export default class ListFlights extends Component {
    constructor(props) {
        super(props);
        this.service = new FlightService();

        this.state = {
            flights:'',
            selectedFlight:'',
            showDetails:false,
            newFlight:false,
            editFlight:false
        }
    }

    getFlights() {
        this.setState({flights:this.service.getFlights()});
    }

    componentDidMount() {
        this.getFlights();
    }

    onSelection = (code) => {
        this.setState({selectedFlight:this.service.getFlightbyCode(code),
            showDetails:true,
            editFlight:false,
            newFlight:false
        });

    }

    onNewFlight = () => {
        this.setState({
            showDetails:false,
            newFlight:true,
            editFlight:false
        });
    }

    render() {
        if(!this.state.flights)
            return null;
        
        const list = this.state.flights.map((x) => 
            <li key={x.code} onClick={() => this.onSelection(x.code)}>{x.code}</li>
        );

        return(
            <div class = "jumbotron">
                <h1>List of Flight</h1>
                <ul class="list-group">
                    {list}
                </ul>
                <br />
                <button class="btn btn-success" onClick={() => this.onNewFlight()}>Add New Flight</button>
                <hr />
                
                {
                    this.state.showDetails && this.state.selectedFlight &&
                    <FlightDetails flight = {this.state.selectedFlight} onEdit={this.onEditFlight} />
                }
                {
                    this.state.newFlight && 
                    <AddFlight />
                }
                {
                    this.state.editFlight && this.state.selectedFlight &&
                    <EditFlight flight={this.state.selectedFlight} />
                }
            </div>
        );
    }
    
    onEditFlight = () => {
        this.setState({
            showDetails:false,
            editFlight:true,
            newFlight:false
        });
    }
}