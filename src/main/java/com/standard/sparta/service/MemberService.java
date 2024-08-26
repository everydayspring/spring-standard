package com.standard.sparta.service;

import com.standard.sparta.domain.Member;
import com.standard.sparta.dto.MemberCreateRequestDto;
import com.standard.sparta.dto.MemberDto;
import com.standard.sparta.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {
    // 1. 속성
    private final MemberRepository memberRepository;

    // 2. 생성자
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 3. 메서드
    public void createMember(MemberCreateRequestDto request) {
        Member newMember = new Member(null, request.getName(), request.getEmail(), false);
        memberRepository.save(newMember);
    }

    public List<MemberDto> getMemberList() {
        List<Member> memberList =  memberRepository.findAll();

        return memberList.stream()
                .map(member -> new MemberDto(member.getId(), member.getName(), member.getEmail()))
                .toList();
    }
}
