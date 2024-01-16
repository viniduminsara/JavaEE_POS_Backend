package lk.ijse.javaee_pos_backend.bo.custom;

import lk.ijse.javaee_pos_backend.bo.SuperBO;
import lk.ijse.javaee_pos_backend.dto.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderBO extends SuperBO {
    boolean saveOrder(OrderDTO orderDTO, Connection connection) throws SQLException;

    List<OrderDTO> getAllOrder(Connection connection) throws SQLException;
}
