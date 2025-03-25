package com.keyin.member;

import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/createMember")
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @GetMapping("/getMemberByName?name={memberName}")
    public ResponseEntity<Member> getMemberByName(@RequestParam String name) {
        return ResponseEntity.ok(memberService.getMemberByName(name));
    }

    @GetMapping("/getMemberByMembershipType?membershipType={membershipType}")
    public ResponseEntity<List<Member>> getMemberByMembershipType(@RequestParam String membershipType) {
        return ResponseEntity.ok(memberService.getMembersByMembershipType(membershipType));
    }

    @GetMapping("/getMemberByPhoneNumber?phoneNumber={phoneNumber}")
    public Member getMemberByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return memberService.getMemberByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getMemberByMembershipStartDate?MembershipStartDate={MembershipStartDate}")
    public Member getMemberByMembershipStartDate(@RequestParam("membershipStartDate") String membershipStartDate) {
        return memberService.getMemberByMembershipStartDate(membershipStartDate);

    }

    @GetMapping("/getAllMembers")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}