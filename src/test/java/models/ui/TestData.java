package models.ui;

/**
 * Created by chandanjavaregowda on 03/04/17.
 */
public class TestData {
    private String url;
    private String username;
    private String password;
    private String name;
    private String mobileNumber;
    private String emailId;
    private String inCorrectPasswordErrorMessage;
    private String loggedInMessage;
    private String userLoggedOutMessage;
    private String createdAccountMessage;
    private String noPasswordMessage;

    public String getNoPasswordMessage() {
        return noPasswordMessage;
    }

    public void setNoPasswordMessage(String noPasswordMessage) {
        this.noPasswordMessage = noPasswordMessage;
    }

    public String getCreatedAccountMessage() {
        return createdAccountMessage;
    }

    public void setCreatedAccountMessage(String createdAccountMessage) {
        this.createdAccountMessage = createdAccountMessage;
    }

    public String getUserLoggedOutMessage() {
        return userLoggedOutMessage;
    }

    public void setUserLoggedOutMessage(String userLoggedOutMessage) {
        this.userLoggedOutMessage = userLoggedOutMessage;
    }

    public String getLoggedInMessage() {
        return loggedInMessage;
    }

    public void setLoggedInMessage(String loggedInMessage) {
        this.loggedInMessage = loggedInMessage;
    }

    public String getInCorrectPasswordErrorMessage() {
        return inCorrectPasswordErrorMessage;
    }

    public void setInCorrectPasswordErrorMessage(String inCorrectPasswordErrorMessage) {
        this.inCorrectPasswordErrorMessage = inCorrectPasswordErrorMessage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
