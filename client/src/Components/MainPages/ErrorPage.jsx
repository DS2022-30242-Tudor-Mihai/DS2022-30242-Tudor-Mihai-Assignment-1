import React, {Component} from "react";
import { Link } from 'react-router-dom';
export default class ErrorPage extends Component{
    render(){
        return(
            <div class="mt-4 p-5 bg-dark text-white rounded text-center">
                <h1 style={{color: 'red'}}>
                    ERROR! PAGE NOT FOUND
                </h1>
                <h2>
                    Maybe you accessed something that does not exist or something 
                        that you are not allowed to access
                </h2>
                    <Link   
                        to="/" 
                        className="btn bg-dark text-white rounded text-center"
                        style={{ textDecoration: 'underline' }}
                    >
                        Go Back to the Login Page
                    </Link>
            </div>
            
        );
    }
}