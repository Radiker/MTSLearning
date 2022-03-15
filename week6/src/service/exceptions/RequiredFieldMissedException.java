package service.exceptions;

public class RequiredFieldMissedException extends RuntimeException{
    public RequiredFieldMissedException(String message) {
        super(message);
    }
    public RequiredFieldMissedException() {
        super("Required Field Missed");
    }
}
