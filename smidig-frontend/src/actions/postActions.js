import axios from "axios";
import { GET_ERRORS } from "./types";

{
  /*
    Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
    en del av koden er ogsaa inspirert av dette prosjektet
    */
}

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
