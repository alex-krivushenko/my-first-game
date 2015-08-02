package interfaces;

import main.UserProfile;

/**
 * Created by Alex on 01.08.2015.
 */
public interface AccountService {
    int USER_NOT_FOUND = 1;
    int BAD_CREDENTIALS = 2;
    int USER_CREATE_OK = 3;
    int USER_AUTH_OK = 4;
    int USER_EXIST = 5;

    int signUpUser(String userName, String password, String email);
    int signInUser(String userName, String password);
    UserProfile getUser(String userName);
    UserProfile getSession(String sessionId);
}
