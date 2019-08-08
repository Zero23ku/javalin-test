package zero23ku;

import io.javalin.Javalin;
import zero23ku.controllers.UserController;
import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws Exception{
        UserController userController = UserController.getInstance();
        Javalin app = Javalin.create().start(7000);
        app.routes(() -> {
            path("user", () -> {
                get(userController.getAllUsers);
                post(userController.createUser);
            });
            path("user/:rut", () -> {
                delete(userController.deleteUser);
                get(userController.getUser);
            });
        });
    }
}
