package lk.ijse.javaee_pos_backend.bo.custom.impl;

import lk.ijse.javaee_pos_backend.bo.custom.CustomerBO;
import lk.ijse.javaee_pos_backend.dao.DAOFactory;
import lk.ijse.javaee_pos_backend.dao.custom.CustomerDAO;
import lk.ijse.javaee_pos_backend.dto.CustomerDTO;
import lk.ijse.javaee_pos_backend.entity.Customer;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean createCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException {
        return customerDAO.save(connection, new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact()
        ));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO, Connection connection) throws SQLException {
        return customerDAO.update(connection, new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getContact()
        ));
    }

    @Override
    public boolean deleteCustomer(String customerId, Connection connection) throws SQLException {
        return customerDAO.delete(connection, customerId);
    }
}
