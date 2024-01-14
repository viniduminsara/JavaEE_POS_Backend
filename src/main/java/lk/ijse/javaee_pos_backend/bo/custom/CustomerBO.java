package lk.ijse.javaee_pos_backend.bo.custom;

import lk.ijse.javaee_pos_backend.bo.SuperBO;
import lk.ijse.javaee_pos_backend.dto.CustomerDTO;

import java.sql.Connection;

public interface CustomerBO extends SuperBO {
    boolean createCustomer(CustomerDTO customerDTO, Connection connection);
}
