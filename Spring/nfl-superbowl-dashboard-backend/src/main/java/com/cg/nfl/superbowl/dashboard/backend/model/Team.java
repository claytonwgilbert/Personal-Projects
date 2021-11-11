package com.cg.nfl.superbowl.dashboard.backend.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private Long totalAppearances;
    private Long totalWins = 0L;

    public Team() {
    }

    public Team(String teamName, Long totalAppearances) {
        this.teamName = teamName;
        this.totalAppearances = totalAppearances;
    }
}
