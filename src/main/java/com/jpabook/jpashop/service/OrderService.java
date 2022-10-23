package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.*;
import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.ItemRepository;
import com.jpabook.jpashop.repository.MemberRepository;
import com.jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;

    private final OrderRepository orderRepository;

    private final ItemRepository itemRepository;

    public Long order(Long memberId, Long itemId, int count) {
        Member member = memberRepository.findById(memberId).orElseThrow(NullPointerException::new);
        Item item = itemRepository.findById(itemId).orElseThrow(NullPointerException::new);

        Delivery delivery = new Delivery(member.getAddress());
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NullPointerException::new);
        order.cancel();
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAll(orderSearch.toSpecification());
    }

}
