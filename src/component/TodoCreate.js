import React from 'react'
import { connect } from 'react-redux'
import store from '../store/store'
import { setDataintoLocalStorage, deleteDataintoLocalStorage } from '../action/action'
var objectarr = [];
var deleteArray = []
class TodoCreate extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            name: [],
            dueDate: [],
            dateCompleted: [],
            check: false,
            Update: false
        }

    }
    handlechange = (event) => {
        let value = event.target.value;
        if (event.target.name === "check") {
            value = event.target.checked
        }
        this.setState({
            [event.target.name]: value
        })

    }
    handlesubmit = (event) => {
        event.preventDefault();
        objectarr.push(this.state);
        store.dispatch(setDataintoLocalStorage(objectarr));
        this.setState({ Update: true })

    }
    handleDelete = (event) => {
        const userdata = this.props.localStorage;
        var abc = userdata.splice(event, 1);
        deleteArray.push(abc[0]);
        store.dispatch(setDataintoLocalStorage(userdata));
        store.dispatch(deleteDataintoLocalStorage(deleteArray))
        this.setState({ Update: true })

    }
    handleUpdate = (index) => {
        const data = JSON.parse(localStorage.getItem("Add"));
        data[index].check = this.state.check;
        store.dispatch(setDataintoLocalStorage(data));
        alert("Updated Successfully");

    }
    handleClearLocalStorage = () => {
        console.log("[Storage Clear]");
       store.dispatch(setDataintoLocalStorage(''));
       store.dispatch(deleteDataintoLocalStorage(''));
       localStorage.clear();
       alert("Local Storage Data Clear");
    }

    render() {
        const list = this.props.localStorage;

        const data = list ? list.map((ele, index) => {
            console.log(ele);
            return (
                <tbody>
                    <tr>
                        {/* <td>{index}</td> */}
                        <td>{ele.name}</td>
                        <td>{ele.dueDate}</td>
                        <td>{ele.dateCompleted}</td>
                        <td>
                            <input defaultChecked={ele.check} name="check" type="checkbox" onChange={this.handlechange} />
                        </td>
                        <td>
                            <span style={{ paddingRight: "inherit" }}><button onClick={() => this.handleDelete(index)}>Delete</button></span>
                            <button onClick={() => this.handleUpdate(index)}>Task Update</button>
                        </td>
    
                    </tr>

                </tbody>
            )
        }) : ""
        return (
            <div>
                <div>
                    <div class="page-header">
                        <h3 style={{ textAlign: "center" }}>Add Todo List</h3>
                    </div>

                    <form class="form-inline" onSubmit={this.handlesubmit}>
                        <label for="name" class="mr-sm-2">Name:</label>
                        <input type="text" class="form-control mb-2 mr-sm-2" name="name" onChange={this.handlechange} />
                        <label for="pwd" class="mr-sm-2">Due Date:</label>
                        <input type="date" class="form-control mb-2 mr-sm-2" name="dueDate" onChange={this.handlechange} />
                        <label for="pwd" class="mr-sm-2">Completed Date:</label>
                        <input type="date" class="form-control mb-2 mr-sm-2" name="dateCompleted" onChange={this.handlechange} />
                        <div class="form-check mb-2 mr-sm-2">
                            <label class="form-check-label">
                                <input class="form-check-input" defaultChecked={false} name="check" type="checkbox" onChange={this.handlechange} />Completed
    </label>
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Submit</button>
                    </form>
                </div>





                <br />
                <div>
                    <div class="page-header">
                        <h3 style={{ textAlign: "center" }}>Update & Delete Item in List</h3>
                        <button type="button" class="btn btn-outline-danger"onClick={this.handleClearLocalStorage} style ={{float:"right"}}>Clear Storage</button>
                    </div>

                    <table class="table table-hover">
                        <thead>
                            <tr>
                                {/* <th scope="col">Id</th> */}
                                <th scope="col">Name</th>
                                <th scope="col">Due Date</th>
                                <th scope="col">Completed Date</th>
                                <th scope="col">Task Completed</th>
                                <th>Action</th>
                               


                            </tr>
                        </thead>
                        {data}
                    </table>
                </div>
            </div>


        )
    }

}
var mapStatetoProps = (state) => {
    console.log("1111", state.reducer);
    return {
        localStorage: state.reducer.localStorage
    }
}

export default connect(mapStatetoProps)(TodoCreate);