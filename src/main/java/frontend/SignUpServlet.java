package frontend;

import main.AccountServiceDevImpl;

import javax.servlet.http.HttpServlet;

/**
 * Created by Alex on 01.08.2015.
 */
public class SignUpServlet extends HttpServlet {
    private AccountServiceDevImpl accountService;

    public SignUpServlet(AccountServiceDevImpl accountService) {
        this.accountService = accountService;
    }
}
