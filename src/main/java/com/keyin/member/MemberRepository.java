package com.keyin.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    Iterable<Member> findMemberByTournamentId(Long tournamentId);
    Optional<Member> findByMemberID(Long memberId);
}
