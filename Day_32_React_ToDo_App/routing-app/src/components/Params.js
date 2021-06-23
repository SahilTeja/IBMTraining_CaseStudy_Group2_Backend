import React from 'react'
import {BrowserRouter as Router,
        Switch, Route, Link, useParams } from 'react-router-dom';

export default function Params() {
    return (
        <Router>
            <div>
                <h1>Channels</h1>
                <ul>
                    <li><Link to="/netflix">Netflix</Link></li>
                    <li><Link to="/amazon-prime">Amazon Prime</Link></li>
                    <li><Link to="/apple-tv">Apple TV</Link></li>
                </ul>
                <Link to="/hotstar">Hotstar</Link>
                <hr />
                <Switch>  
                    {/* /:ch --> /netflix  --> :ch works as Getmapping & postMapping URL as Spring*/}
                    <Route path="/:ch" children={<Child />} />
                </Switch>
            </div>
        </Router>
    );
}

function Child() {
    let {ch} = useParams();

    return (
        <h2>Channel : {ch}</h2>
    );
}