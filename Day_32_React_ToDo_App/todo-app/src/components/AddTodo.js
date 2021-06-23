import { Component } from 'react'

export default class AddTodo extends Component {
    state = {id :0, task : '', status:'Pending'};

    handleSubmit = (event) => {
        event.preventDefault();
        this.props.onAdd({id:this.state.id, task:this.state.task, status:this.state.status});
        this.setState({id:0, task:'', status:'Pending'});
    }
    render() {
        return(
            <div>
                <h1>Add toDo</h1>
                <form onSubmit={this.handleSubmit}>
                    <table>
                        <tr>
                            <td>Id</td>
                            <td><input value={this.state.id} onChange={e=>this.setState({id:e.target.value})} /></td>
                        </tr>
                        <tr>
                            <td>Task</td>
                            <td><input value={this.state.task} onChange={e=>this.setState({task:e.target.value})} /></td>
                        </tr>
                        <tr>
                            <td>Status</td>
                            <td>
                                <input type="radio" name="status" onChange={e=>this.setState({status:'Pending'})} />Pending
                                <input type="radio" name="status" onChange={e=>this.setState({status:'Completed'})} />Completed
                            </td>
                        </tr>
                        <tr><th colSpan="2"><button type="submit">Add Tools</button></th></tr>
                    </table>
                </form>
            </div>
        );
    }
} 