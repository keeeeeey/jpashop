package com.jpabook.jpashop.controller;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.domain.item.Item;
import com.jpabook.jpashop.repository.MemberRepository;
import com.jpabook.jpashop.service.ItemService;
import com.jpabook.jpashop.service.MemberService;
import com.jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    private MemberService memberService;

    private ItemService itemService;

//    @GetMapping("/order")
//    public String createForm(Model model) {
//        List<Member> memberList = memberService.findMembers();
//        List<Item> itemList = itemService.findItems();
//
//        model.addAttribute("memberList", memberList);
//        model.addAttribute("itemList", itemList);
//
//        return "order/orderForm";
//    }

    @PostMapping("/order")
    public Long order(@RequestParam("memberId") Long memberId,
                      @RequestParam("itemId") Long itemId,
                      @RequestParam("count") int count) {
        return orderService.order(memberId, itemId, count);
    }

}
