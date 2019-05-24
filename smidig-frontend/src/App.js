import React, {Component} from 'react';
import Header from './components/header/Header'
import Dashboard from './components/header/Dashboard'
import {Provider} from 'react-redux'
import store from './store'
import './App.css';

class App extends Component{

render(){
  return (
    <Provider store={store}>
    <div className="App">

<Header/>


    </div>
  </Provider>
  );
}
}
export default App;
