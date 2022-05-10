import React from 'react';
import ReactDOM from 'react-dom';
import App from './component/Home';
import { BrowserRouter } from 'react-router-dom';
import store from './store/store'
import { Provider } from 'react-redux'
import { setDataintoLocalStorage, deleteDataintoLocalStorage } from './action/action';

var localData = JSON.parse(localStorage.getItem("Add"));
var delData = JSON.parse(localStorage.getItem("delete"));

store.dispatch(setDataintoLocalStorage(localData));
store.dispatch(deleteDataintoLocalStorage(delData));
ReactDOM.render(
    <Provider store={store}>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </Provider>, document.getElementById('root'));

