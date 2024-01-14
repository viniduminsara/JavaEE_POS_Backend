package lk.ijse.javaee_pos_backend.dao.custom;

import lk.ijse.javaee_pos_backend.dao.SuperDAO;
import lk.ijse.javaee_pos_backend.entity.Customer;

import java.sql.Connection;

public interface CustomerDAO extends SuperDAO {
    boolean save(Connection connection, Customer customer);
}
