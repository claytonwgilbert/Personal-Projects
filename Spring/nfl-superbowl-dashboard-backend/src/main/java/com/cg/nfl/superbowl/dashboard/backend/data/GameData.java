package com.cg.nfl.superbowl.dashboard.backend.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameData {

    private String date;
    private String sb;
    private String winner;
    private String winner_pts;
    private String loser;
    private String loser_pts;
    private String mvp;
    private String stadium;
    private String city;
    private String state;
}
