package zero23ku.repository;

import java.util.List;
import java.util.ArrayList;
import zero23ku.doman.*;

public class UsersRepository{

    private static UsersRepository usersRepository = null;
    List<User> users; 

    UsersRepository() throws Exception{

        if(usersRepository != null){
            throw new Exception("repository already exist!");
        }

        User user1 = new User();
        User user2 = new User();
        user1.setNombre("Pepe");
        user1.setRut("111111-1");
        user2.setNombre("Jose");
        user2.setRut("222222-2");
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
    }

    public static UsersRepository getInstance() throws Exception{
        if(usersRepository == null){
            usersRepository = new UsersRepository();
        }

        return usersRepository;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getAllUsers(){
        return this.users;
    }

    public void deleteUser(String rut){
        users.removeIf( e -> e.getRut().equals(rut));
    }

    public User getUser(String rut){
        return this.users.stream()
                         .filter(e -> e.getRut().equals(rut))
                         .findFirst()
                         .orElse(null);
    }

    public Boolean userExists(String rut){
        return this.users.stream()
                         .anyMatch( e -> e.getRut().equals(rut));
    }

}