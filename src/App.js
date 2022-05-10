import React from 'react';
import { Route, Switch } from 'react-router-dom'
import TodoCreate from './component/TodoCreate'
import Home1 from './component/Home1'
import Completed from './component/Completed'
import Trash from './component/Trash'
import { Error } from './component/error'
import './App.css';

function App() {
  return (
    <Switch>
       <Route exact path="/" component={Home1} />
      <Route  path="/home" component={Home1} />
      <Route path="/add" component={TodoCreate} />
      <Route path="/completed" component={Completed} />
      <Route path="/trash" component={Trash} />
      <Route component={Error} />
    </Switch>
  );
}

export default App;
