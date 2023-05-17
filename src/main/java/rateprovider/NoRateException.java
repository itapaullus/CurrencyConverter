package rateprovider;

public class NoRateException extends Exception {
    public NoRateException(String message) {
        super(message);
    }
}
