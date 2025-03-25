package com.keyin.tournament;

import com.keyin.member.Member;
import com.keyin.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private MemberService memberService;

    @PostMapping("/createTournament")
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    @PostMapping("/{tournamentId}/add-member/{memberId}")
    public ResponseEntity<String> addMemberToTournament(@PathVariable long tournamentId, @PathVariable long memberId) {
        Tournament tournament = tournamentService.getTournamentById(tournamentId);
        Member member = memberService.getMemberById(memberId);

        if (tournament == null || member == null) {
            return new ResponseEntity<>("Member or tournament not found", HttpStatus.NOT_FOUND);
        }

        if (tournament.getParticipatingMembers().contains(member)) {
            return new ResponseEntity<>("Player Is Already In This Tournament", HttpStatus.CONFLICT);
        }

        tournament.getParticipatingMembers().add(member);
        tournamentService.createTournament(tournament);

        return new ResponseEntity<>("Player Added To Tournament!", HttpStatus.CREATED);
    }

    @GetMapping("/getTournamentByStartDate?startDate={Date}")
    public Tournament getTournamentByStartDate(@RequestParam("startDate") String startDate) {
        return tournamentService.getTournamentByStartDate(startDate);
    }

    @GetMapping("/getTournamentByLocation?location={location}")
    public Tournament getTournamentByLocation(@RequestParam String location) {
        return tournamentService.getTournamentByLocation(location);
    }

    @GetMapping("/getAllMembersInATournamentByTournamentId/{tournamentId}")
    public Iterable<Member> getAllMembersInATournamentByTournamentId(@PathVariable long tournamentId){
        return tournamentService.getAllMembersInATournamentByTournamentId(tournamentId);
    }

    @GetMapping("/getAllTournaments")
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }
}