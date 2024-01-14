package lk.ijse.javaee_pos_backend.api;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.javaee_pos_backend.bo.BOFactory;
import lk.ijse.javaee_pos_backend.bo.custom.CustomerBO;
import lk.ijse.javaee_pos_backend.db.DBProcess;
import lk.ijse.javaee_pos_backend.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "customer", urlPatterns = "/customer", loadOnStartup = 5)
public class Customer extends HttpServlet {

    Logger logger = LoggerFactory.getLogger(Customer.class);
    CustomerBO customerBO = (CustomerBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.CUSTOMER);
    private Connection connection;

    @Override
    public void init() throws ServletException {
        logger.info("Init the customer servlet");

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
        if (req.getContentType() != null && req.getContentType().toLowerCase().startsWith("application/json")){
            Jsonb jsonb = JsonbBuilder.create();
            CustomerDTO customerDTO = jsonb.fromJson(req.getReader(), CustomerDTO.class);

            if(customerBO.createCustomer(customerDTO, connection)){
                logger.info("Customer is saved");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                logger.error("Failed to save");
                resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
