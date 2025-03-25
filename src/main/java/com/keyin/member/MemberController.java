package com.keyin.member;

import com.keyin.tournament.Tournament;
import com.keyin.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TournamentService tournamentService;


    @PostMapping("/addNewMember")
    public Member addNewMember(@RequestBody Member member) {
        List<Tournament> tournamentsFromRequest = member.getTournaments();
        if (tournamentsFromRequest == null) {
            tournamentsFromRequest = new ArrayList<>();
        }

        List<Tournament> updatedTournamentList = new ArrayList<>();

        for (Tournament tournament : tournamentsFromRequest) {
            Optional<Tournament> tournamentOptional = Optional.ofNullable(
                    tournamentService.findByTournamentName(tournament.getTournamentName())
            );

            if (tournamentOptional.isPresent()) {
                updatedTournamentList.add(tournamentOptional.get());
            } else {
                updatedTournamentList.add(tournamentService.addTournament(tournament));
            }
        }

        member.setTournaments(updatedTournamentList);
        return memberService.addMember(member);
    }


    @PutMapping("/assignTournamentToMember/{memberId}/{tournamentName}")
    public ResponseEntity<Member> assignTournamentToMember(
            @PathVariable Long memberId,
            @PathVariable String tournamentName) {

        Optional<Member> memberOptional = memberService.getMemberById(memberId);
        Tournament tournament = tournamentService.findByTournamentName(tournamentName);

        if (memberOptional.isEmpty() || tournament == null) {
            return ResponseEntity.notFound().build();
        }

        Member member = memberOptional.get();

        // Get current tournaments, add new one if not already present
        List<Tournament> tournaments = member.getTournaments();
        if (!tournaments.contains(tournament)) {
            tournaments.add(tournament);
            member.setTournaments(tournaments);
            memberService.addMember(member); // Save updated member
        }

        return ResponseEntity.ok(member);
    }


    @GetMapping("/listAllMembers")
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        memberService.getAllMembers();
        return ResponseEntity.ok().body(memberService.getAllMembers());
    }

    @GetMapping("/getMemberById/{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long memberId) {
        Optional<Member> member = memberService.getMemberById(memberId);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberByName/{memberName}")
    public ResponseEntity<Member> getMemberByName(@PathVariable String memberName) {
        Optional<Member> member = memberService.getMemberByName(memberName);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberByMembership/{membershipType}")
    public ResponseEntity<List<Member>> getMemberByMembership(@PathVariable String membershipType) {
        Optional<List<Member>> member = memberService.getMemberByMembership(membershipType);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getMemberPhoneNumber/{phoneNumber}")
    public ResponseEntity<Member> getMemberByPhoneNumber(@PathVariable String phoneNumber) {
        Optional<Member> member = memberService.getMemberByPhoneNumber(phoneNumber);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteMemberById/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        if (memberService.deleteMember(memberId)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/getMembersByTournamentName/{tournamentName}")
    public ResponseEntity<Optional<List<Member>>> getMemberByTournamentName(@PathVariable String tournamentName) {
        Optional<List<Member>> members = memberService.getMemberByTournamentName(tournamentName);
        if (members.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(members);
    }
}