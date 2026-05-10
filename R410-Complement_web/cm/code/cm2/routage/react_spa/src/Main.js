import React, { Component } from "react";

import {
    Routes,
    Route,
    NavLink,
    HashRouter
} from "react-router-dom";

import But2 from "./But2";
import S3 from "./S3"
import S4 from "./S4"


class Main extends Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <HashRouter>
            <div>
                <h1>S4</h1>
                <ul className="header">
                    <li><NavLink to="/">BUT2</NavLink></li>
                    <li><NavLink to="/S3">S3</NavLink></li>
                    <li><NavLink to="/S4">S4</NavLink></li>
                </ul>
                <div className="content">
                    <Routes>
                    <Route exact path="/" Component={But2} />
                    <Route path="/S3" Component={S3} />
                    <Route path="/S4" Component={S4} />
                    </Routes>
                </div>
            </div>
            </HashRouter>
        );
    }
}

export default Main