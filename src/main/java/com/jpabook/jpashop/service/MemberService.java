package com.jpabook.jpashop.service;

import com.jpabook.jpashop.domain.Member;
import com.jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 전체 회원 조회
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 단건 조회
    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(NullPointerException::new);
    }

    // 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

}
