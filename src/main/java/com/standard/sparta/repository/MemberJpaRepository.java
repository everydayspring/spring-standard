package com.standard.sparta.repository;

import com.standard.sparta.domain.Member;

import java.util.List;

public class MemberJpaRepository implements MemberRepository {
    @Override
    public Member save(Member member) {
        //
        return null;
    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return List.of();
    }
}
