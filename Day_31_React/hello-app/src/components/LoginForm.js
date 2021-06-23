import { Component } from 'react'

export default class LoginForm extends Component {

    state = {name : '',age : ''};

    updateState = (event) =>{
        
        let name1 = event.target.name;
        let value1 = event.target.value;
        this.setState({[name1]:value1});
    }
    submitHandler = ()=>{
        alert("Details are Submitted for Name: "+this.state.name + " and is age is "+this.state.age);
    } 
    render() {
        return(
            // <form onSubmit={this.submitHandler}>
            //     <label>Enter Name:</label><br/>
            //     <input type="text" onChange={e=> this.setState({name : e.target.value})} />
            //     Hello {this.state.name}<br/><br/>
            //     <label>Age :</label><br/>
            //     <input type="text" onChange={e=> this.setState({age : e.target.value})} />
            //     Age is {this.state.age}<br/><br/>
            //     <button type="submit">Submit</button>
            // </form>
            <form onSubmit={this.submitHandler}>
                <label>Enter Name:</label><br/>
                <input type="text" name="name" onChange={this.updateState} />
                Hello {this.state.name}<br/><br/>
                <label>Age :</label><br/>
                <input type="text" name="age" onChange={this.updateState} />
                Age is {this.state.age}<br/><br/>
                <button type="submit">Submit</button>
            </form>
        );
    }
}