package sample;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class HttpServer {

    public static void main(String[] args) {
        
    }

    public void start() throws Exception {

        Server server = new Server();
        ServerConnector http = new ServerConnector(server);
        http.setHost("127.0.0.1");
        http.setPort(8080);
        server.addConnector(http);

        ServletHandler servletHandler = new ServletHandler();
        servletHandler.addServletWithMapping(CreateQueueServlet.class, "/CREATE/*");
        server.setHandler(servletHandler);

        server.start();
        server.join();

    }
    
}
