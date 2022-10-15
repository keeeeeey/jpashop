package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.domain.item.Movie;
import com.jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    public void 상품저장() {

        // When
        Movie movie = new Movie();
        movie.setName("반지의 제왕");
        movie.setActor("비고 모텐슨");
        movie.setDirector("피터 잭슨");

        // Given
        Long id = itemService.saveItem(movie);

        // Then
        assertEquals(movie, itemRepository.findOne(id));

    }

}