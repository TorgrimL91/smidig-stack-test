import React, { Component } from "react";
import SignUp from "./SignUp";
import Dashboard from "./Dashboard";
import "./header.css";
import { Route, NavLink, HashRouter, BrowserRouter } from "react-router-dom";

class Header extends Component {
  render() {
    return (
      <div>
        <HashRouter>
          <nav className="navbar navbar-expand-sm navbar-dark bg-primary mb-4">
            <div className="container">
              <a className="navbar-brand" href="Dashboard.html">
                UNIK
              </a>

              <button
                className="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#mobile-nav"
              >
                <span className="navbar-toggler-icon" />
              </button>

              <div className="collapse navbar-collapse" id="mobile-nav">
                <ul className="navbar-nav mr-auto">
                  <li className="nav-item">
                    <NavLink to="/Dashboard">
                      <p1> Dashboard</p1>
                    </NavLink>
                  </li>
                </ul>

                <ul className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <a className="nav-link " href="register.html">
                      <NavLink to="/SignUp">
                        <p1> Sign Up</p1>
                      </NavLink>

                      <div className="content" />
                    </a>
                  </li>

                  <li className="nav-item">
                    <a className="nav-link" href="login.html">
                      Login
                    </a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
          <Route path="/SignUp" component={SignUp} />
          <Route path="/Dashboard" component={Dashboard} />
        </HashRouter>
      </div>
    );
  }
}

export default Header;
