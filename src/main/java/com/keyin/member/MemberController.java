package com.keyin.member;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/getMemberByName")
    public Member getMemberByName(@RequestParam("name") String name) {
        return memberService.getMemberByName(name);
    }

    @GetMapping("/getMemberByMembershipType")
    public Member getMemberByMembershipType(@RequestParam("membershipType") String membershipType) {
        return memberService.getMemberByMembershipType(membershipType);
    }

    @GetMapping("/getMemberByPhoneNumber")
    public Member getMemberByPhoneNumber(@RequestParam("phoneNumber") String phoneNumber) {
        return memberService.getMemberByPhoneNumber(phoneNumber);
    }

    @GetMapping("/getMemberByMembershipStartDate")
    public Member getMemberByMembershipStartDate(@RequestParam("membershipStartDate") String membershipStartDate) {
        return memberService.getMemberByMembershipStartDate(membershipStartDate);

    }

    @GetMapping("/getAllMembers")
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}