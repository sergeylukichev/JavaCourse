package com.telran.project.tracker.controller;

import com.telran.project.tracker.exception.ItemNotFoundException;
import com.telran.project.tracker.model.entity.Item;
import com.telran.project.tracker.model.entity.ItemStatus;
import com.telran.project.tracker.model.entity.User;
import com.telran.project.tracker.model.web.ItemRequest;
import com.telran.project.tracker.model.web.ItemResponse;
import com.telran.project.tracker.repository.ItemRepository;
import com.telran.project.tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public ItemResponse createItem(@RequestBody ItemRequest itemRequest, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());

        Item item = Item.builder()
                .itemName(itemRequest.getItemName())
                .itemType(itemRequest.getItemType())
                .itemStatus(ItemStatus.TODO)
                .createdDate(new Date())
                .user(user)
                .build();

        return new ItemResponse(itemRepository.save(item));
    }

    @PutMapping("/update/{id}")
    public ItemResponse updateItem(@RequestBody ItemRequest itemRequest, @PathVariable("id") Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(itemId));

        item.setItemName(itemRequest.getItemName());
        item.setItemType(itemRequest.getItemType());

        return new ItemResponse(itemRepository.save(item));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
    }

    @GetMapping("/all")
    public List<ItemResponse> getItems(
            @RequestParam(value = "name", required = false) String name) {
        if (name == null || name.trim().isEmpty()) {

            return itemRepository.findAll()
                    .stream()
                    .map(ItemResponse::new)
                    .collect(Collectors.toList());
        }
        return itemRepository.findAllByItemNameContaining(name)
                .stream()
                .map(ItemResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/all/me")
    public List<ItemResponse> getMyItems(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        return itemRepository.findAllByUser(user)
                .stream()
                .map(ItemResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/proceed/{id}")
    public ItemResponse proceedItem(@PathVariable("id") Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        item.setItemStatus(item.getItemStatus().getNextPhase());
        return new ItemResponse(itemRepository.save(item));
    }


}
