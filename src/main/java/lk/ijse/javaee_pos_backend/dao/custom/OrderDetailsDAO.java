package lk.ijse.javaee_pos_backend.dao.custom;

import lk.ijse.javaee_pos_backend.dao.CrudDAO;
import lk.ijse.javaee_pos_backend.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends CrudDAO<OrderDetails, String> {

    List<OrderDetails> get(Connection connection, String orderId) throws SQLException;

}
