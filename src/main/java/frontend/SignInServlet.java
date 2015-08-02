package frontend;


import interfaces.AccountService;
import main.AccountServiceDevImpl;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 01.08.2015.
 */
public class SignInServlet extends HttpServlet {
    private AccountServiceDevImpl accountService;

    public SignInServlet(AccountServiceDevImpl accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> pageVariables = new HashMap<>();

        pageVariables.put("login_status", request.getSession().getId());
        try {
            response.getWriter().println(PageGenerator.getPage("signin.html", pageVariables));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> pageVariables = new HashMap<>();

        String userName = request.getParameter("login");
        String password = request.getParameter("password");

        switch (accountService.signInUser(userName, password)) {
            case AccountService.BAD_CREDENTIALS:
                pageVariables.put("login_status", "Password is incorrect");
                break;
            case AccountService.USER_AUTH_OK:
                pageVariables.put("login_status", "User authorised");
                break;
            case AccountService.USER_NOT_FOUND:
                pageVariables.put("login_status", "User not found");
        }

        try {
            response.getWriter().println(PageGenerator.getPage("signin.html", pageVariables));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
