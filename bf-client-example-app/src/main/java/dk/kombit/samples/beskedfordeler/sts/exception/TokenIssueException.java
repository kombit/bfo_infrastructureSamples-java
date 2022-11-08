package dk.kombit.samples.beskedfordeler.sts.exception;

/**
 * TokenIssueException class thrown when token cannot be obtained.
 */
public class TokenIssueException extends Exception {

    public TokenIssueException(String message, Exception e) {
        super(message, e);
    }

}
