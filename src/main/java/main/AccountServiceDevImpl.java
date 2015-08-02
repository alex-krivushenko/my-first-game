package main;


import interfaces.AccountService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 01.08.2015.
 */
public class AccountServiceDevImpl implements AccountService {
    private static AccountServiceDevImpl ourInstance = new AccountServiceDevImpl();
    private Map<String, UserProfile> users = new HashMap<>();
    private Map<String, UserProfile> sessions = new HashMap<>();

    public static AccountServiceDevImpl getInstance() {
        return ourInstance;
    }
    private AccountServiceDevImpl() {}

    @Override
    public int signUpUser(String userName, String password, String email) {
        if(users.containsKey(userName))
            return USER_EXIST;
        UserProfile newUser = new UserProfile(userName, password, email);
        users.put(userName, newUser);
        return USER_CREATE_OK;
    }

    @Override
    public int signInUser(String userName, String password) {
        if(users.containsKey(userName)) {
            if(users.get(userName).getPassword().equals(password))
                return USER_AUTH_OK;
            return BAD_CREDENTIALS;
        }
        return USER_NOT_FOUND;
    }

    @Override
    public UserProfile getUser(String userName) {
        return users.get(userName);
    }

    @Override
    public UserProfile getSession(String sessionId) {
        return sessions.get(sessionId);
    }

}
