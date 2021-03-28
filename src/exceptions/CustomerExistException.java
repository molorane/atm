package exceptions;

public class CustomerExistException extends RuntimeException {

    public CustomerExistException(String message) {
        super(message);
    }
}
