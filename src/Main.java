import middlewares.CheckPermissionMiddleware;
import middlewares.CheckUsersMiddleware;
import middlewares.Middleware;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static Server server;
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void init(){
        server = new Server();
        server.registerUser("master@gmail.com", "123456");
        server.registerUser("user@gmail.com", "123456");

        Middleware middleware = new CheckUsersMiddleware(server);
        middleware.linkWith(new CheckPermissionMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
       init();
       boolean done ;

       do{
           System.out.println("Digite o e-mail: ");
           String email = reader.readLine();
           System.out.println("Digite a sua senha: ");
           String password = reader.readLine();
           done = server.login(email, password);
       } while (!done);
    }
}