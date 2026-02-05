package org.example.Controller;

import org.example.DTO.ItemRequestDto;
import org.example.DTO.ItemResponseDto;
import org.example.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponseDto> addItem(
            @Valid @RequestBody ItemRequestDto requestDto) {

        return ResponseEntity.ok(itemService.addItem(requestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponseDto> getItem(@PathVariable Long id) {

        return ResponseEntity.ok(itemService.getItemById(id));
    }
}
