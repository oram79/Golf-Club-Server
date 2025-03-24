package com.keyin.tournament;

import com.keyin.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    Optional<Tournament> findByDateStart(Date startDate);
    Optional<Tournament> findByLocation(String location);
}