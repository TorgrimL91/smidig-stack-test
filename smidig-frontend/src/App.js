import React, {Component} from 'react';
import Header from './components/header/Header'
import Dashboard from './components/header/Dashboard'
import {Provider} from 'react-redux'
import store from './store'
import './App.css';

class App extends Component{

{
  /*
  Alle Designelementer er basert paa https://github.com/AgileIntelligence/AgileIntPPMTool
  en del av koden er ogsaa inspirert av dette prosjektet
  */
}

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
