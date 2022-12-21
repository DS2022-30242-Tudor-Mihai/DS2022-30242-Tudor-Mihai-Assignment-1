import {React} from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import LoginComponent from "./Components/MainPages/LoginComponent";

import ErrorPage from "./Components/MainPages/ErrorPage";

function App() {
  return (
    <div className="App bg-dark">
      <Router>
        <Routes>
          <Route path="/" exact element={<LoginComponent />}/>
          <Route path="/error" exact element={<ErrorPage/>}/>
        </Routes>
    </Router>
    </div>
  );
}

export default App;
