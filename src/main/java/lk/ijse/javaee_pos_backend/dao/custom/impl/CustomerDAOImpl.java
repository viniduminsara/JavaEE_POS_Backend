package lk.ijse.javaee_pos_backend.dao.custom.impl;

import lk.ijse.javaee_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.javaee_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDAOImpl implements CustomerDAO {

    private static final String SAVE_CUSTOMER = "INSERT INTO customer(customer_id, name, address, contact) VALUES (?,?,?,?)";

    @Override
    public boolean save(Connection connection, Customer customer) {
        try {
            PreparedStatement ps = connection.prepareStatement(SAVE_CUSTOMER);
            ps.setString(1, customer.getCustomerId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getAddress());
            ps.setInt(4, customer.getContact());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
