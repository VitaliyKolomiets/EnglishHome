package sa.com.exeption;

import lombok.Getter;

public class FoodServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    @Getter
    private ServiceErrorCode errorCode;

    public FoodServiceException() {
        super();
    }

    public FoodServiceException(String message) {
        super(message);
    }

    public FoodServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public FoodServiceException(ServiceErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FoodServiceException(String message, ServiceErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public FoodServiceException(String message, ServiceErrorCode errorCode, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
