import React from 'react'
import { connect } from 'react-redux'
import store from '../store/store';
import { setDataintoLocalStorage, deleteDataintoLocalStorage } from '../action/action';
var deleteArray = [];
class Trash extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            update: false
        }
    }

    handleStore = (index) => {
        const storeData = this.props.delData;
        const localStorage = this.props.localStorage;

        var restore = storeData[index];
        localStorage.push(restore);
        store.dispatch(setDataintoLocalStorage(localStorage));
        var abc = storeData.splice(index, 1);
        deleteArray.push(abc[0]);
        store.dispatch(deleteDataintoLocalStorage(storeData));
        this.setState({ update: true });
    }

    render() {
        const list = this.props.delData;
        console.log();
        const data = list ? list.map((ele, index) => {
            return (
                <tbody>
                    <tr>
                        <td>{ele.name}</td>
                        <td>{ele.dueDate}</td>
                        <td>{ele.dateCompleted}</td>
                        <td>
                            <input defaultChecked={ele.check} name="check" type="checkbox" readOnly style={{ pointerEvents: "none" }} />
                        </td>
                        <td>
                            <button onClick={() => this.handleStore(index)}>Restore</button>
                        </td>

                    </tr>

                </tbody>
            )
        }) : ""

        return (
            <div>
                <div class="page-header">
                    <h3 style={{ textAlign: "center" }}>Deleted Todo's</h3>
                </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
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
        )
    }

}
var mapStatetoProps = (state) => {
    return {
        delData: state.reducer.delData,
        localStorage: state.reducer.localStorage,

    }
}
export default connect(mapStatetoProps)(Trash);