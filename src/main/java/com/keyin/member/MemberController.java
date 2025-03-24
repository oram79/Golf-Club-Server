package com.keyin.member;

import com.keyin.tournament.TournamentRepository;
import com.keyin.tournament.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private TournamentService tournamentService;

    @GetMapping("/getAllMembers")
    public Iterable<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PostMapping("/addNewMember")
    public Member addNewMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/findByMemberID/{memberID}")
    public ResponseEntity<Member> findByMemberID(@PathVariable Long memberID) {
        Optional<Member> member = memberService.findByMemberId(memberID);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
