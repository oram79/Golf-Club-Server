package com.keyin.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    List<Member> findByMemberName(String name);
    List<Member> findByPhoneNumber(String phoneNumber);
}
