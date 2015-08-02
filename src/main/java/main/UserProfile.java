package main;

/**
 * Created by Alex on 01.08.2015.
 */
public class UserProfile {
    private String userName;
    private String password;
    private String email;

    public UserProfile (String userName, String password, String email) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setEmail(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
