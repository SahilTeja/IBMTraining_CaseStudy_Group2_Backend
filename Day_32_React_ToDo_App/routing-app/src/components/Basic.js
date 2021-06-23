import React from 'react'
import {BrowserRouter as Router,
        Switch, Route, Link } from 'react-router-dom';

export default function Basic() {
    return (
        <Router>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/about">About</Link></li>
                <li><Link to="/dash">Dashboard</Link></li>
            </ul>
            <hr />
            <Switch>
                <Route exact path ="/">
                    <Home />
                </Route>
                <Route exact path ="/about">
                    <About />
                </Route>
                <Route exact path ="/dash">
                    <Dashboard />
                </Route>
            </Switch>
        </Router>
    );
}

function Home() {
    return (
        <div>
            <h2>Home Page</h2>
        </div>
    );
}
function About() {
    return (
        <div>
            <h2>About Page</h2>
        </div>
    );
}
function Dashboard() {
    return (
        <div>
            <h2>Dashboard Page</h2>
        </div>
    );
}