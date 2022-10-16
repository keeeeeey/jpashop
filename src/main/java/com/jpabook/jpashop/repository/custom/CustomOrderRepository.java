package com.jpabook.jpashop.repository.custom;

import com.jpabook.jpashop.domain.Order;
import com.jpabook.jpashop.domain.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);
}
