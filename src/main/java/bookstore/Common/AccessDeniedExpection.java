package bookstore.Common;

public class AccessDeniedExpection extends RuntimeException {

    public AccessDeniedExpection(String message){
        super(message);
    }


}
