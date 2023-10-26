package Execptons;

public class myExecption extends RuntimeException {
    private String errorCode;

    public myExecption(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public myExecption(String message) {
        super(message);

    }


    public String getErrorCode() {
        return errorCode;
    }
}
