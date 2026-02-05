package org.example.Service;

import org.example.DTO.ItemRequestDto;
import org.example.DTO.ItemResponseDto;

public interface ItemService {


    ItemResponseDto addItem(ItemRequestDto requestDto);

    ItemResponseDto getItemById(Long id);
}
