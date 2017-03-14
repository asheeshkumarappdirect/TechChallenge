package tech.models;

public class ResponseSuccess {
	public ResponseSuccess(boolean success, String accountIdentifier) {
        super();
        this.success = success;
        this.accountIdentifier = accountIdentifier;
    }
    private boolean success;
    private String accountIdentifier;
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getAccountIdentifier() {
        return accountIdentifier;
    }
    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }
}
