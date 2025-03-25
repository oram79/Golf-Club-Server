package com.keyin.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    public Member findByName(String name);
    public List<Member> findByMembershipType(String membershipType);
    public Member findByPhoneNumber(String phoneNumber);
    public Member findMemberByMembershipStartDate(String membershipStartDate);
}