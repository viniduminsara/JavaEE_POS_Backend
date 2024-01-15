package lk.ijse.javaee_pos_backend.dao.custom.impl;

import lk.ijse.javaee_pos_backend.dao.SQLUtil;
import lk.ijse.javaee_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.javaee_pos_backend.entity.Customer;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    private static final String SAVE_QUERY = "INSERT INTO customer(customer_id, name, address, contact) VALUES (?,?,?,?)";
    private static final String UPDATE_QUERY = "UPDATE customer SET name = ?, address = ?, contact = ? WHERE customer_id = ?";

    @Override
    public boolean save(Connection connection, Customer customer) throws SQLException {
        return SQLUtil.execute(connection,
                SAVE_QUERY,
                customer.getCustomerId(),
                customer.getName(),
                customer.getAddress(),
                customer.getContact()
            );
    }

    @Override
    public boolean update(Connection connection, Customer customer) throws SQLException {
        return SQLUtil.execute(connection,
                UPDATE_QUERY,
                customer.getName(),
                customer.getAddress(),
                customer.getContact(),
                customer.getCustomerId()
            );
    }

}
