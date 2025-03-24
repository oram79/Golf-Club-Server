package com.keyin.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }


}
