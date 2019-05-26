import React, { Component } from "react";
import axios from 'axios'



class ProjectItem extends Component {


  state = {
   postContent: []
 }



componentDidMount() {
this.getPost();

}



  getPost(){

    axios.get(`http://localhost:8080/api/post/all`)
    .then(function (response) {
    // handle success
    console.log(response);
  })
  .catch(function (error) {
    // handle error
    console.log(error);
  })
  .finally(function () {
    // always executed
  });
}



  render() {

    return (

      <div className="container">

        <div className="card card-body bg-light mb-3">

          <div className="row">

            <div className="col-2">

              <span className="mx-auto">REACT</span>

            </div>

            <div className="col-lg-6 col-md-4 col-8">

              <h3>Spring / React Project</h3>

              <p>  <ul>

      </ul></p>

            </div>

            <div className="col-md-4 d-none d-lg-block">

              <ul className="list-group">

                <a href="#">

                  <li className="list-group-item board">

                    <i className="fa fa-flag-checkered pr-1"> Project Board </i>

                  </li>

                </a>

                <a href="#">

                  <li className="list-group-item update">

                    <i className="fa fa-edit pr-1"> Update Project Info</i>

                  </li>

                </a>

                <a href="">

                  <li className="list-group-item delete">

                    <i className="fa fa-minus-circle pr-1"> Delete Project</i>

                  </li>

                </a>

              </ul>

            </div>

          </div>

        </div>

      </div>

    );

  }

}



export default ProjectItem;
