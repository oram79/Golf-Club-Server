package com.keyin.tournament;

import com.keyin.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private MemberRepository memberRepository;

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Iterable<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Optional<Tournament> getTournamentById(Long tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);
    }

    public Optional<Tournament> findByTournamentId(Long tournamentId) {
        return tournamentRepository.findByTournamentId(tournamentId);

    }

    public Tournament findByTournamentName(String tournamentName) {
        return tournamentRepository.findByTournamentName(tournamentName);

    }

    public Optional<Tournament> getTournamentByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public Optional<Tournament> getTournamentByStartDate(String startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public boolean deleteTournament(Long tournamentId) {
        if (tournamentRepository.existsById(tournamentId)) {
            tournamentRepository.deleteById(tournamentId);
        } else {
            throw new RuntimeException("City not found with id " + tournamentId);
        }
        return false;
    }
}