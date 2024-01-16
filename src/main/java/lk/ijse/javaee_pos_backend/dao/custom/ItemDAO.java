package lk.ijse.javaee_pos_backend.dao.custom;

import lk.ijse.javaee_pos_backend.dao.CrudDAO;
import lk.ijse.javaee_pos_backend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item, String> {

    Item get(Connection connection, String itemId) throws SQLException;
}
