import React from 'react'
import {BrowserRouter as Router,
        Switch, Route, Link, useParams, useRouteMatch } from 'react-router-dom';

export default function Nested() {
    return (
        <Router>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/topics">Topics</Link></li>
            </ul>
            <Switch>
                <Route exact path="/">
                    <Home />
                </Route>
                <Route path="/topics">
                    <Topics />
                </Route>
            </Switch>
        </Router>
    );
}

function Home() {
    return (<h2>Home Component</h2>);
}
function Topics() {
    let {path, url} = useRouteMatch();

    return (
        <div>
            <h2>Topic Component</h2>
            {/* <h3>{url}</h3> */}
            <ul>
                <li><Link to={`${url}/spring`}>Spring FrameWork</Link></li>
                <li><Link to={`${url}/angular`}>Angular FrameWork</Link></li>
                <li><Link to={`${url}/react`}>React JS FrameWork</Link></li>
            </ul>
            <hr />
            <Switch>
                <Route exact path={path}>
                    <h3>Please Select a topic</h3>
                </Route>
                <Route path={`${path}/:top`}>
                    <Topic />
                </Route>
            </Switch>
        </div>
    );
}

function Topic() {
    let {top} = useParams();

    return( <h1>You are learning :{top}</h1>);
}