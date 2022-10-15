package com.jpabook.jpashop.controller;

import com.jpabook.jpashop.domain.item.Book;
import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

//    @GetMapping("/items/new")
//    public String createForm() {
//        return "items/createItemForm";
//    }

    @PostMapping("/items/new")
    public Long create(Book item) {
        return itemService.saveItem(item);
    }

    @GetMapping("/items")
    public List<Item> list() {
        return itemService.findItems();
    }

//    @GetMapping("/items/{itemId}/edit")
//    public String updateItemForm(@PathVariable("itemId") Long itemId, Model model) {
//        Item item = itemService.findOne(itemId);
//        model.addAttribute("item", item);
//        return "items/updateItemForm";
//    }

    @PostMapping("/items/{itemId}/edit")
    public Long updateItem(@PathVariable("itemId") Long itemId) {
        Item item = itemService.findOne(itemId);
        Long savedItemId = itemService.saveItem(item);
        return savedItemId;
    }

}
