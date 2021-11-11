package com.cg.nfl.superbowl.dashboard.backend.controller;

import com.cg.nfl.superbowl.dashboard.backend.model.Team;
import com.cg.nfl.superbowl.dashboard.backend.repositories.GameRepository;
import com.cg.nfl.superbowl.dashboard.backend.repositories.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private GameRepository gameRepository;

    public TeamController(TeamRepository teamRepository, GameRepository gameRepository) {
        this.teamRepository = teamRepository;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team foundTeam = teamRepository.findByTeamName(teamName);
        foundTeam.setGamesPlayed(gameRepository.getByWinnerOrLoserOOrderBySbDateDesc(teamName, teamName));
        // - If we had alot of results and needed to return only a few results to work with on the front end
        //foundTeam.setGamesPlayed(gameRepository.findLatestGamesByTeam(teamName, 4));

        return foundTeam;
    }
}
