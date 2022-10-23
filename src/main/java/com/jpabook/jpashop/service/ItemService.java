package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public Long saveItem(Item item) {
        itemRepository.save(item);
        return item.getId();
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public Item findOne(Long id) {
        return itemRepository.findById(id).orElseThrow(NullPointerException::new);
    }

}
