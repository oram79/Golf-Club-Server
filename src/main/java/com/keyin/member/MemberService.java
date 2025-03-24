package com.keyin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Iterable<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findByName(Long name) {
        return memberRepository.findByName(name);
    }

    public Optional<Member> findByMemberId(Long memberId) {
        return memberRepository.findByMemberID(memberId);
    }

    public Iterable<Member> findByTournamentId(Long tournamentId) {
        return memberRepository.findMemberByTournamentId(tournamentId);
    }

}
