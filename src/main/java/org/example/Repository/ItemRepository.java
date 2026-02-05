package org.example.Repository;

import org.example.DAO.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class ItemRepository {

    private final List<Item> itemList = new ArrayList<>();
    private Long idCounter = 1L;

    public Item save(Item item) {
        item.setId(idCounter++);
        itemList.add(item);
        return item;
    }

    public Optional<Item> findById(Long id) {
        return itemList.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }
}
