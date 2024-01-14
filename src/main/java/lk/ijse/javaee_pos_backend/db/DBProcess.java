package lk.ijse.javaee_pos_backend.db;

import lk.ijse.javaee_pos_backend.dto.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBProcess {

    private static final String SAVE_CUSTOMER = "INSERT INTO customer(customer_id, name, address, contact) VALUES (?,?,?,?)";

    public static boolean createCustomer(CustomerDTO customerDTO, Connection connection){
        try {
            PreparedStatement ps = connection.prepareStatement(SAVE_CUSTOMER);
            ps.setString(1, customerDTO.getCustomerId());
            ps.setString(2, customerDTO.getName());
            ps.setString(3, customerDTO.getAddress());
            ps.setInt(4, customerDTO.getContact());

            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
