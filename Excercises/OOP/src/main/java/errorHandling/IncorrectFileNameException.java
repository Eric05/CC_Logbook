package errorHandling;

public class IncorrectFileNameException extends Exception {
    public IncorrectFileNameException(String errorMessage, Throwable th) {
        super(errorMessage, th);
    }

    public IncorrectFileNameException(String w) {
    }
}
