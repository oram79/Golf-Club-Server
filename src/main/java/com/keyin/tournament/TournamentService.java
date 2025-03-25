package com.keyin.tournament;

import com.keyin.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    public Tournament createTournament(Tournament newTournament) {
        return tournamentRepository.save(newTournament);
    }

    public Tournament getTournamentByStartDate(String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public Tournament getTournamentByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public Tournament getTournamentById(long tournamentId) {
        Optional<Tournament> tournamentOptional = tournamentRepository.findById(tournamentId);

        return tournamentOptional.orElse(null);
    }

    public Iterable<Member> getAllMembersInATournamentByTournamentId(long tournamentId) {
        return tournamentRepository.findById(tournamentId)
                .map(Tournament::getParticipatingMembers)
                .orElse(Collections.emptyList());
    }

    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) tournamentRepository.findAll();
    }
}