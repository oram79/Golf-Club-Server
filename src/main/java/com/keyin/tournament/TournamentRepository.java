package com.keyin.tournament;

import com.keyin.member.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    List<Tournament> findByDateStart(Date startDate);
    List<Tournament> findByLocation(String location);
}