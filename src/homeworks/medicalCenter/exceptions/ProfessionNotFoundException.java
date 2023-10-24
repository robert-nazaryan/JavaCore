package homeworks.medicalCenter.exceptions;

public class ProfessionNotFoundException extends Exception {
    @Override
    public String toString() {
        return "Profession does not found";
    }

    public ProfessionNotFoundException() {
    }

    public ProfessionNotFoundException(String message) {
        super(message);
    }

    public ProfessionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProfessionNotFoundException(Throwable cause) {
        super(cause);
    }

    public ProfessionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
