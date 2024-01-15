package lk.ijse.javaee_pos_backend.dao.custom;

import lk.ijse.javaee_pos_backend.dao.SuperDAO;
import lk.ijse.javaee_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO extends SuperDAO {
    boolean save(Connection connection, Customer customer) throws SQLException;

    boolean update(Connection connection, Customer customer) throws SQLException;
}
