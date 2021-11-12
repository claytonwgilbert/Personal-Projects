package com.cg.nfl.superbowl.dashboard.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    private Long totalAppearances;
    private Long totalWins = 0L;

    @Transient // - Prevents database from saving this field as a column
    private List<Game> gamesPlayed;

    public Team() {
    }

    public Team(String teamName, Long totalAppearances) {
        this.teamName = teamName;
        this.totalAppearances = totalAppearances;
    }
}
