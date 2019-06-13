import axios from "axios";
import { GET_ERRORS } from "./types";

export const createPost = (username, post, history) => async dispatch => {
  try {
    const res = await axios.post(`http://localhost:8080/api/user/${username}`);
    history.push("/dashboard");
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};
