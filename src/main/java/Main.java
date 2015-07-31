import frontend.AuthServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Alexander on 31.07.2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        AuthServlet frontend = new AuthServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(frontend), "/authform");

        Server server = new Server(8082);
        server.setHandler(context);

        server.start();
        server.join();
    }

}
