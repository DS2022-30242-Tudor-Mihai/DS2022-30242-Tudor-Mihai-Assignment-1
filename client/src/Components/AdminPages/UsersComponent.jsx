import React, {Component} from "react";
import UserService from "../../Services/UserService";
import { Table} from "react-bootstrap";

export default class UsersComponent extends Component{
    
    constructor(props){
        super(props)
        this.state = {
            users:[]
        }
    }

    componentDidMount(){
        UserService.getUsers().then((response) => {
            this.setState({ users : response.data })
        });
    }

    render(){
        return(
                <div>
                    <h1 className = "text-center"> All the Users</h1>
                    <Table border="true" hover striped variant="dark">
                        <thead>
                            <tr>
                                <td>User Id</td>
                                <td>User Username</td>
                                <td>User Role</td>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                    <tr key = {user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.username}</td>
                                        <td>{user.role}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </Table>
                </div>
            )
    }
}