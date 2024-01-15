package lk.ijse.javaee_pos_backend.api;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "item", urlPatterns = "/item", loadOnStartup = 5)
public class Item extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(Item.class);
    private Connection connection;

    @Override
    public void init() throws ServletException {
        logger.info("Init the item servlet");

        try {

            InitialContext context = new InitialContext();
            DataSource pool = (DataSource) context.lookup("java:comp/env/jdbc/javaee_pos");
            this.connection = pool.getConnection();
            logger.info("Obtained new connection (" + connection + ") to customer servlet");

        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
