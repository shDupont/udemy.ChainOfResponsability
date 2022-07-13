package middlewares;

public class CheckPermissionMiddleware extends Middleware{
    @Override
    public boolean check(String email, String password) {
        if(email.equals("master@gmail.com")){
            System.out.println("Bem vindo adm");
        } else {
        System.out.println("Bem vindo!");
        }
        return checkNext(email, password);
    }
}
