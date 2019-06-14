import React, { Component } from "react";

import ProjectItem from "./ProjectItem";

{
  /*
  Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
  en del av koden er ogsaa inspirert av dette prosjektet
  */
}

class Dashboard extends Component {
  render() {
    return (
      <div className="projects">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">User profile page</h1>

              <br />

              <br />

              <hr />

              <ProjectItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
