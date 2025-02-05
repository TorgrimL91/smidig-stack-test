import { createStore, applyMiddleware, compose } from "redux";
import thunk from "redux-thunk";
import rootReducer from "./components/reducers/index";



const initalState = {};

const middleware = [thunk];



let store;



if (("Chrome")) {

  store = createStore(

    rootReducer,

    initalState,

    compose(

      applyMiddleware(...middleware),

      window.__REDUX_DEVTOOLS_EXTENSION__ &&

        window.__REDUX_DEVTOOLS_EXTENSION__()

    )

  );

} else {

  store = createStore(

    rootReducer,

    initalState,

    compose(applyMiddleware(...middleware))

  );

}



export default store;
