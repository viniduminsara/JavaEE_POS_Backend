package lk.ijse.javaee_pos_backend.bo.custom.impl;

import lk.ijse.javaee_pos_backend.bo.custom.ItemBO;
import lk.ijse.javaee_pos_backend.dao.DAOFactory;
import lk.ijse.javaee_pos_backend.dao.custom.ItemDAO;
import lk.ijse.javaee_pos_backend.dto.ItemDTO;
import lk.ijse.javaee_pos_backend.entity.Item;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean createItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        return itemDAO.save(connection, new Item(
                itemDTO.getItemId(),
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQty()
        ));
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO, Connection connection) throws SQLException {
        return itemDAO.update(connection, new Item(
                itemDTO.getItemId(),
                itemDTO.getDescription(),
                itemDTO.getUnitPrice(),
                itemDTO.getQty()
        ));
    }

    @Override
    public boolean deleteItem(String itemId, Connection connection) throws SQLException {
        return itemDAO.delete(connection, itemId);
    }

    @Override
    public List<ItemDTO> getAllItems(Connection connection) throws SQLException {
        List<Item> items = itemDAO.getAll(connection);
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(new ItemDTO(
                    item.getItemId(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQty()
            ));
        }
        return itemDTOS;
    }
}
