package com.jpabook.jpashop.domain;

import com.jpabook.jpashop.repository.MemberRepository;
import com.jpabook.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void 즉시조회() {
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("lee");

        Member member3 = new Member();
        member3.setName("park");

        Order order1 = new Order();
        order1.setMember(member1);

        Order order2 = new Order();
        order2.setMember(member2);

        Order order3 = new Order();
        order3.setMember(member3);

        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        em.clear();

        List<Member> members = memberRepository.findAll();

    }

}