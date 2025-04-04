package com.keyin.tournament;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends CrudRepository<Tournament, Long> {
    public Tournament findByStartDate(String startDate);
    public Tournament findByLocation(String location);
}