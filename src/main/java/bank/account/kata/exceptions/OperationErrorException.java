package bank.account.kata.exceptions;

public class OperationErrorException extends Exception {

    public OperationErrorException(String msg) {
        super(msg);
    }

    public OperationErrorException(String msg, Throwable e) {
        super(msg, e);
    }
}
