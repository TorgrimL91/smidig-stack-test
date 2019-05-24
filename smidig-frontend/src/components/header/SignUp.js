import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createUser } from "../../actions/userActions";




class SignUp extends Component {

  constructor(){
    super()

    this.state={
        userName: "",
        firstName: "",
        lastName: "",
        email: "",
        phoneNumber: "",
        password: ""

    };
    this.onSubmit = this.onSubmit.bind(this);
    this.onChange = this.onChange.bind(this);
  }

onChange(e){
  this.setState({[e.target.name]:e.target.value})


}

onSubmit(e){
  e.preventDefault();
  const newUser= {
    userName: this.state.userName,
    firstName: this.state.firstName,
    lastName: this.state.lastName,
    email: this.state.email,
    phoneNumber: this.state.phoneNumber,
    password: this.state.password
  };


   this.props.createUser(newUser, this.props.history);
}

  render() {

    return (

      <div className="signup-form">
      <h1>Sign in</h1>
      <br/>
      <form onSubmit={this.onSubmit}>
    <div className="form-row">

      <div className="col-md-4 mb-3">

        <input type="text" name="firstName" className="form-control is-valid" id="validationServer01" placeholder="First name" value={this.state.firstName} onChange={this.onChange.bind(this)} required />
        <div className="valid-feedback">

        </div>
      </div>


      <div className="col-md-4 mb-3">

        <input type="text" name="lastName" className="form-control is-valid" id="validationServer02" placeholder="Last name" value={this.state.lastName} onChange={this.onChange.bind(this)} required/>
        <div className="valid-feedback">

        </div>
      </div>


      <div className="col-md-4 mb-3">

        <div className="form-row">
          <div className="input-group-prepend">

          </div>
          <input type="text" name="userName" className="form-control is-valid" id="validationServerUsername" placeholder="Username" aria-describedby="inputGroupPrepend3" value={this.state.userName} onChange={this.onChange.bind(this)} required/>
          <div className="invalid-feedback">

          </div>
        </div>
      </div>
    </div>


    <div className="form-row">
      <div className="col-md-4 mb-3">

        <input type="text"name="email" className="form-control is-valid" id="validationServer03" placeholder="e-mail" value={this.state.email} onChange={this.onChange.bind(this)} required/>
        <div className="invalid-feedback">

        </div>
      </div>

      <div className="col-md-4 mb-3">

        <input type="text" name="phoneNumber" className="form-control is-valid" id="validationServer04" placeholder="phone" value={this.state.phoneNumber} onChange={this.onChange.bind(this)}required/>
        <div className="invalid-feedback">

        </div>
      </div>


      <div className="col-md-4 mb-3">

        <input type="text" name="password" className="form-control is-valid" id="validationServer05" placeholder="password" value={this.state.password} onChange={this.onChange.bind(this)}required/>
        <div className="invalid-feedback">

        </div>
      </div>
    </div>


    <button className="btn btn-primary" type="submit">Register</button>
  </form>
      </div>



);
  }

}

SignUp.propTypes = {

  createUser: PropTypes.func.isRequired

};



export default connect(null, {createUser}) (SignUp);
