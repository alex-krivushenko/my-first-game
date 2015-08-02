package main;

import frontend.SignInServlet;
import frontend.SignUpServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * Created by Alexander on 31.07.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AccountServiceDevImpl accountService = AccountServiceDevImpl.getInstance();

        accountService.signUpUser("test", "test", "test@test.ru");

        Servlet signin = new SignInServlet(accountService);
        Servlet signup = new SignUpServlet(accountService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(signin), "/signin");
        context.addServlet(new ServletHolder(signup), "/signup");

        //обработка статики
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});

        Server server = new Server(8082);
        server.setHandler(handlers);

        server.start();
        server.join();
    }

}
