package lk.ijse.javaee_pos_backend.bo.custom;

import lk.ijse.javaee_pos_backend.bo.SuperBO;
import lk.ijse.javaee_pos_backend.dto.OrderDetailsDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsBO extends SuperBO {
    List<OrderDetailsDTO> getOrderDetails(String orderId, Connection connection) throws SQLException;

    boolean saveOrderDetails(List<OrderDetailsDTO> details, Connection connection) throws SQLException;
}
