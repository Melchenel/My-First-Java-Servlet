package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AllRequestsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestServlet = new AllRequestsServlet(); //класс обработчик запросов

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestServlet), "/mirror");

        Server server = new Server(8080); // запуск сервера на порту 8080
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}