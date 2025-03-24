package com.keyin.member;

import com.keyin.tournament.Tournament;
import com.keyin.tournament.TournamentService;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;
    private String address;
    private String email;
    private String phoneNum;
    private Date memberSin;
    private int duration;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Tournament TournamentId;

    public Member() {

    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Date memberSin() {
        return memberSin;
    }

    public void setMemberSin(Date memberSin) {
        this.memberSin = memberSin;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }


    public String toString() {
        return "Member: " + name +
                ", ID:" + memberId +
                ", Phone: " + phoneNum +
                ", Email: " + email +
                ", Address: " + address +
                ", Member Since: " + memberSin +
                ", Membership: " + duration;
    }
}
