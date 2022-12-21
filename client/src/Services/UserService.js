import axios from "axios";
import PORT from "./_port.js";

const NAME = 'user'

const USERS_URL = PORT + NAME ;

class UserService{
    getUsers(){
        return axios.get(USERS_URL);
    }

    postUser(user){
        return axios.post(USERS_URL, user);
    }

    putUser(user){
        return axios.put(USERS_URL, user);
    }

    deleteUser(id){
        return axios.delete(USERS_URL + "/" + id);
    }

    findbyid(id){
        return axios.get(USERS_URL + "/find/" + id);
    }

    addDeviceToUser(userId, deviceId){
        return axios.put(USERS_URL + "/" + userId + "/" + deviceId);
    }
}

export default new UserService();