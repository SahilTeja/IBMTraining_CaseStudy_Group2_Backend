import { Component } from 'react'
import AddTodo from './AddTodo';

export default class TodoList extends Component {
    state = {
        todos : [
            {id:1, task:'Develop the code', status:'Complete'},
            {id:2, task:'Commit to Git', status:'Pending'}
        ]
    };

    addTodo = (todo) => {
        this.setState({
            todos : [...this.state.todos, todo]  //...this.state.todos--> current toDo list  
            //todos : [...this.state.todos, todo] --> adding new todo at last in currentTodo list
        });
    }

    deleteTodo = (todo) => {
        const filteredTodos = this.state.todos.filter(x => x.id !== todo.id);
        // store all toDo expecpt the deleted toDo in filteredTodos and update todos with filteredTodos
        this.setState({todos : filteredTodos});
    }

    toggleStatus = (todo) => {
        this.setState(state => ({
            todos : state.todos.map(x => {
                if(x.id === todo.id) {
                    return {...x, status:x.status=== 'Pending' ? 'Completed' : 'Pending'};
                }
                else{
                    return x;
                }
            })
        }));
    }

    render() {
        return (
            <div>
                <AddTodo onAdd={this.addTodo} />
                <h1>ToDo List</h1>
                <table border="2" width="500">
                    <tr><th>Id</th><th>task</th><th>Status</th><th>Action</th></tr>
                    <tbody>
                        {this.state.todos.map(x => {    //it is like *ngFor=let x in todos
                            return (
                                <tr>
                                    <td>{x.id}</td>
                                    <td>{x.task}</td>
                                    <td><a href="#" onClick={()=>this.toggleStatus(x)}>{x.status}</a></td>
                                    <td><button onClick={() => this.deleteTodo(x)}>Delete</button></td>
                                </tr>
                            );
                        })}
                    </tbody>
                </table>
            </div>
        );
    }
}