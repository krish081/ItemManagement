package org.example.ServiceImpl;

import org.example.DAO.Item;
import org.example.DTO.ItemRequestDto;
import org.example.DTO.ItemResponseDto;
import org.example.Service.ItemService;
import org.example.Repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public ItemResponseDto addItem(ItemRequestDto requestDto) {

        Item item = new Item();
        item.setName(requestDto.getName());
        item.setDescription(requestDto.getDescription());
        item.setPrice(requestDto.getPrice());

        Item savedItem = itemRepository.save(item);

        return new ItemResponseDto(
                savedItem.getId(),
                savedItem.getName(),
                savedItem.getDescription(),
                savedItem.getPrice()
        );
    }

    @Override
    public ItemResponseDto getItemById(Long id) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));

        return new ItemResponseDto(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice()
        );
    }
}