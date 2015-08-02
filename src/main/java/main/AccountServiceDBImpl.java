package main;

/**
 * Created by Alex on 01.08.2015.
 */
public class AccountServiceDBImpl {
    private static AccountServiceDBImpl ourInstance = new AccountServiceDBImpl();

    public static AccountServiceDBImpl getInstance() {

        return ourInstance;
    }

    private AccountServiceDBImpl() {
    }
}
