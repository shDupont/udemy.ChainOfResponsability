package middlewares;

import server.Server;

public class CheckUsersMiddleware extends Middleware{

    private Server server;

    public CheckUsersMiddleware(Server server){
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if(!server.hasEmail(email)){
            System.out.println("E-mail invalido");
            return false;
        }

        if(!server.isValidPassword(email, password)){
            System.out.println("E-mail ou senha inválido");
            return false;
        }

        return checkNext(email, password);
    }
}
