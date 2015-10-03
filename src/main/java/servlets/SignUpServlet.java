package servlets;

import interfaces.AccountService;
import main.AccountServiceDevImpl;
import templater.PageGenerator;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 01.08.2015.
 */
public class SignUpServlet extends HttpServlet {
    private AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("signup_status", "");
        try {
            response.getWriter().println(PageGenerator.getPage("signup.html", pageVariables));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> pageVariables = new HashMap<>();

        String userName = request.getParameter("login");
        String password = request.getParameter("password");
        String email = "";

        switch (accountService.signUpUser(userName, password, email)) {
            case AccountService.USER_EXIST:
                pageVariables.put("signup_status", "User already exists");
                break;
            case AccountService.USER_CREATE_OK:
                pageVariables.put("signup_status", "User created");
        }
        try {
            response.getWriter().println(PageGenerator.getPage("signup.html", pageVariables));
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
