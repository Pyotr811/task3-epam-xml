package by.epam.home.service;

public class XMLParserServiceException extends Exception {

    public XMLParserServiceException() {
        super();
    }

    public XMLParserServiceException(String message) {
        super(message);
    }

    public XMLParserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public XMLParserServiceException(Throwable cause) {
        super(cause);
    }

    protected XMLParserServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
