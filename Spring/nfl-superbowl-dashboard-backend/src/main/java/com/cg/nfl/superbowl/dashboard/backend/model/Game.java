package com.cg.nfl.superbowl.dashboard.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Game {

    @Id
    private UUID id;
    private LocalDate sbDate;
    private String sb;
    private String winner;
    private String winnerPts;
    private String loser;
    private String loserPts;
    private String mvp;
    private String stadium;
    private String city;
    private String state;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getSbDate() {
        return sbDate;
    }

    public void setSbDate(LocalDate sbDate) {
        this.sbDate = sbDate;
    }

    public String getSb() {
        return sb;
    }

    public void setSb(String sb) {
        this.sb = sb;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getWinnerPts() {
        return winnerPts;
    }

    public void setWinnerPts(String winnerPts) {
        this.winnerPts = winnerPts;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getLoserPts() {
        return loserPts;
    }

    public void setLoserPts(String loserPts) {
        this.loserPts = loserPts;
    }

    public String getMvp() {
        return mvp;
    }

    public void setMvp(String mvp) {
        this.mvp = mvp;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
