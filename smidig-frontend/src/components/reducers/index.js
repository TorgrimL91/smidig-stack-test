import { combineReducers } from "redux";
import errorReducer from "./errorReducer";

{
  /*
  Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
  en del av koden er ogsaa inspirert av dette prosjektet
  */
}

export default combineReducers({
  errors: errorReducer
});
