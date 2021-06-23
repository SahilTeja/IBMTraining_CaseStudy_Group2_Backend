import { Component } from 'react'

export default class Login extends Component {

    state = {userid :'', secret : ''};

    handleSubmit = () => {
        if(this.state.userid === "duke" && this.state.secret === "java")
            alert("Login Successful");
        else
            alert("Invalid UserId/Secret");
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>UserId</label>
                    <input onChange={e => this.setState({userid:e.target.value})}/><br />
                    <label>Secret</label>
                    <input type="password" onChange={e => this.setState({secret:e.target.value})} /><br />
                    <button type="submit">Login</button>
                </form>
                <hr />
                UserId : {this.state.userid}<br />
                Secret : {this.state.secret}<br />
            </div>
        );
    }
}