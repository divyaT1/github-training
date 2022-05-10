import React from 'react'
import { connect } from 'react-redux'

class Completed extends React.Component {

    render() {
        const list = this.props.localStorage;
        const data = list ? list.map((ele, index) => {
            return (
                <tbody>
                    <tr>
                        {/* {ele.check?<td>{index}</td>:""} */}
                        {ele.check ? <td>{ele.name}</td> : ""}
                        {ele.check ? <td>{ele.dueDate}</td> : ""}
                        {ele.check ? <td>{ele.dateCompleted}</td> : ""}
                        {ele.check ? <td>
                            <input defaultChecked={ele.check} name="check" type="checkbox" readOnly style={{ pointerEvents: "none" }} />
                        </td> : ''}
                        {/* {ele.check? <td>
                           
                            <span style={{ paddingRight: "inherit" }}><button onClick={() => this.handleDelete(index)}>Delete</button></span>
                            <button onClick={() => this.handleUpdate(index)}>Update</button>
                            </td>:""} */}

                    </tr>

                </tbody>
            )
        }) : ""

        return (
            <div>
                <div class="page-header">
                    <h3 style={{ textAlign: "center" }}>List Completed Task</h3>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Due Date</th>
                            <th scope="col">Completed Date</th>
                            <th scope="col">Task Completed</th>

                        </tr>
                    </thead>
                    {data}
                </table>


            </div>
        )
    }

}
var mapStatetoProps = (state) => {
    return {
        localStorage: state.reducer.localStorage
    }
}
export default connect(mapStatetoProps)(Completed);