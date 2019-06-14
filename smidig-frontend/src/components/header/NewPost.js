import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createPost } from "../../actions/postActions";

{
  /*
  Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
  en del av koden er ogsaa inspirert av dette prosjektet
  */
}

class NewPost extends Component {
  constructor() {
    super();
    this.state = {
      postContent: "",
      errors: {}
    };
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newPost = {
      postContent: this.state.postContent
    };

    this.props.createPost(newPost, this.props.history);
  }
  render() {
    return (
      <div>
        <div>
          <form>
            <h4>Add post</h4>
            <input
              type="text"
              name="postContent"
              placeholder="Your Post"
              value={this.state.postContent}
              onChange={this.onChange}
            />
            <input type="submit" />
          </form>
        </div>
      </div>
    );
  }
}

NewPost.propTypes = {
  createPost: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { createPost }
)(NewPost);
