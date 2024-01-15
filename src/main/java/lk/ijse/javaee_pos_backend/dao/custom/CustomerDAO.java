package lk.ijse.javaee_pos_backend.dao.custom;

import lk.ijse.javaee_pos_backend.dao.CrudDAO;
import lk.ijse.javaee_pos_backend.dao.SuperDAO;
import lk.ijse.javaee_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer, String> {

}
