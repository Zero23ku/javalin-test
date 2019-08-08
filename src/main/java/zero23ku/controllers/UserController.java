package zero23ku.controllers;

import zero23ku.doman.User;
import zero23ku.services.UserService;
import io.javalin.http.Handler;

public class UserController {

    private static UserController userController = null;
    private static UserService userService = null;

    private UserController() throws Exception{
        if(userController != null){
            throw new Exception("controller already exist!");
        }
    }

    public static UserController getInstance() throws Exception{
        if(userController == null){
            userController = new UserController();
            userService = UserService.getInstance();
        }
        return userController;
    }


    public Handler getAllUsers = ctx -> { 
        ctx.status(200);
        ctx.json(userService.getAllUsers());
    };

    public Handler createUser = ctx -> {
        User user = ctx.bodyValidator(User.class)
                    .check( obj -> obj.getRut() != "" && obj.getRut() != null)
                    .check( obj -> obj.getNombre() != "" && obj.getNombre() != null)
                    .get();
        if(userService.createUser(user)){
            ctx.status(204);
        }else{
            ctx.status(404);
        }
    };

    public Handler deleteUser = ctx -> {
        String rut = ctx.pathParam("rut");
        if(rut == "" ){
            ctx.status(400);
        }else{
            if(userService.deleteUser(rut)){
                ctx.status(204);
            }else{
                ctx.status(404);
            }
        }
    };

    public Handler getUser = ctx -> {
        String rut = ctx.pathParam("rut");
        if(rut == ""){
            ctx.status(400);
        }else{
            ctx.status(200);
            ctx.json(userService.getUser(rut));
        }
    };


    
}