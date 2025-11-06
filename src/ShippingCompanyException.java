public class ShippingCompanyException extends Exception {
    public ShippingCompanyException(String message) {
        super(message);
    }
    
    public ShippingCompanyException(String message, Throwable cause) {
        super(message, cause);
    }
}