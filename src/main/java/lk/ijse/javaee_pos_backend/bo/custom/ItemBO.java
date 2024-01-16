package lk.ijse.javaee_pos_backend.bo.custom;

import lk.ijse.javaee_pos_backend.bo.SuperBO;
import lk.ijse.javaee_pos_backend.dto.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface ItemBO extends SuperBO {

    boolean createItem(ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean updateItem(ItemDTO itemDTO, Connection connection) throws SQLException;

    boolean deleteItem(String itemId, Connection connection) throws SQLException;

    List<ItemDTO> getAllItems(Connection connection) throws SQLException;
}
