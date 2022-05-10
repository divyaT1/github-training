import React from 'react';
import AppRoute from '../App'
import { Link } from 'react-router-dom'
function Home () {
 
        return (
           
            <div>
                <div>
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <Link class="navbar-brand" to="/Home">Todo App</Link>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <Link to='/' class="nav-item nav-link active">Home</Link>
                                <Link class="nav-item nav-link" to="/completed">Completed</Link>
                                <Link class="nav-item nav-link" to="/trash">Trash</Link>
                                <Link class="nav-item nav-link" to="/add">Create</Link>
                            </div>
                        </div>
                    </nav>
                </div>
                <div style={{ alignContent: "center", marginTop: "50px" }}>
                    <AppRoute />
                </div>

            </div>
        )
    }

export default Home;