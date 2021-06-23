
export default class FlightService {
    constructor() {
        this.flights = [
            {code:1211, carrier:'JetAirways', source:'Mumbai', destination:'Goa', duration:'1.30', price:3499},
            {code:2121, carrier:'Indigo', source:'Kochi', destination:'Jaipur', duration:'3.00', price:5999},
            {code:1212, carrier:'JetAirways', source:'Surat', destination:'Kolkata', duration:'2.30', price:4499}
        ];
    }

    getFlights() {
        return this.flights;
    }

    getFlightbyCode(code) {
        return this.flights.find(x => x.code === code);
    }

    saveFlight(flight) {
        this.flights.push(flight);
    }

    updateFlight(flight) {
        var idx = this.flights.indexOf(this.flights.find(x => x.code === flight.code));
        this.flights[idx] = flight;
    }

    deleteFlight(code) {
        this.flights.splice(this.flights.indexOf(this.flights.find(x => x.code === code)),1);
    }
}