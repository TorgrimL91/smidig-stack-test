import React, { Component } from "react";
import axios from "axios";
import { Route, NavLink, HashRouter, BrowserRouter } from "react-router-dom";
import NewPost from "./NewPost";

{
  /*
  Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
  en del av koden er ogsaa inspirert av dette prosjektet
  */
}

var api_url = "http://localhost:8080/api/post/all";
var api_user = "http://localhost:8080/api/user/all";

class ProjectItem extends Component {
  constructor(props) {
    super(props);
    this.getData = this.getData.bind(this);
    this.getUserData = this.getUserData.bind(this);
    this.state = {
      api_data: [],
      user_Data: []
    };
  }

  componentDidMount() {
    this.getData();
    this.getUserData();
  }

  getData() {
    axios
      .get(api_url, {
        withCredentials: false
      })
      .then(res => {
        var api_data = res.data;
        this.setState({ api_data });
        console.log(api_data.length);
        console.log(api_data);
      });
  }

  getUserData() {
    axios
      .get(api_user, {
        withCredentials: false,
        params: {
          userName: "user"
        }
      })
      .then(res => {
        var user_Data = res.data;
        this.setState({ user_Data });
        console.log(user_Data.length);
        console.log(user_Data);
      });
  }

  render() {
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">
                {" "}
                {this.state.user_Data.map(user => (
                  <li>{user.userName}</li>
                ))}
              </span>
            </div>

            <div className="col-lg-6 col-md-4 col-8">
              <h3>Spring / React Project</h3>

              {this.state.api_data.map(firstapi => (
                <tr>
                  <td className="col-lg-6 ">
                    <p>{firstapi.postContent}</p>
                  </td>
                </tr>
              ))}
            </div>

            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <HashRouter>
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">
                      {" "}
                      {this.state.api_data.map(firstapi => (
                        <td>
                          <p>
                            {" "}
                            Created at: <br />
                            {firstapi.created_At}
                          </p>
                        </td>
                      ))}
                    </i>
                  </li>

                  <a href="#">
                    <li className="list-group-item update">
                      <NavLink to="/NewPost"> New Post</NavLink>
                    </li>
                  </a>
                </HashRouter>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default ProjectItem;
