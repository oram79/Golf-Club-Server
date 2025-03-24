package com.keyin.tournament;
import com.keyin.member.Member;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    private Date startDate;
    private Date endDate;
    private String location;
    private double entryFee;
    private double cashPrize;

    public Tournament() {

    }

    public Long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(double cashPrize) {
        this.cashPrize = cashPrize;
    }

    public String toString() {
        return
                ", ID:" + tournamentId +
                ", Start-Date: " + startDate +
                ", End-Date: " + endDate +
                ", Location: " + location +
                ", Entry-Fee: " + entryFee +
                ", Cash Prize: " + cashPrize;
    }
}
