package zero23ku.services;

import java.util.List;

import zero23ku.repository.UsersRepository;
import zero23ku.doman.*;

public class UserService {

    private static UserService userService = null;
    private static UsersRepository usersRepository = null;

    private UserService() throws Exception{
        if(userService != null){
            throw new Exception("Service already exist!");
        }
    }

    public static UserService getInstance() throws Exception{
        if(userService == null){
            userService = new UserService();
            usersRepository = UsersRepository.getInstance();
        }
        return userService;
    }

    public List<User> getAllUsers(){
        return usersRepository.getAllUsers();
    }

    public Boolean createUser(User user){
        if(!usersRepository.userExists(user.getRut())){
            usersRepository.addUser(user);
            return true;
        }
        
        return false;
    }

    public Boolean deleteUser(String rut){
        if(usersRepository.userExists(rut)){
            usersRepository.deleteUser(rut);
            return true;
        }
        return false;
    }

    public User getUser(String rut){
        return usersRepository.getUser(rut);
    }
   


}