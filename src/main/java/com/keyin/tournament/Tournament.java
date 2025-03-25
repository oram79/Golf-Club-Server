package com.keyin.tournament;

import com.keyin.member.Member;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tournament {
    @Id
    @SequenceGenerator(name = "tournament_sequence", sequenceName = "tournament_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "tournament_sequence")
    private long tournamentId;

    private String tournamentName;
    private String startDate;
    private String endDate;
    private String location;
    private String entryFee;
    private String cashPrizeAmount;

    @ManyToMany
    private List<Member> participatingMembers;

    public Tournament() {
    }

    public Tournament(long tournamentId, String tournamentName, String startDate, String endDate, String location, String entryFee, String cashPrizeAmount, List<Member> participatingMembers) {
        this.tournamentId = tournamentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmount = cashPrizeAmount;
        this.participatingMembers = participatingMembers;
    }

    public long getId() {
        return tournamentId;
    }

    public void setId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getCashPrizeAmount() {
        return cashPrizeAmount;
    }

    public void setCashPrizeAmount(String cashPrizeAmount) {
        this.cashPrizeAmount = cashPrizeAmount;
    }

    public List<Member> getParticipatingMembers() {
        return participatingMembers;
    }

    public void setParticipatingMembers(List<Member> participatingMembers) {
        this.participatingMembers = participatingMembers;
    }
}