package com.cg.nfl.superbowl.dashboard.backend.controller;

import com.cg.nfl.superbowl.dashboard.backend.model.Game;
import com.cg.nfl.superbowl.dashboard.backend.model.Team;
import com.cg.nfl.superbowl.dashboard.backend.repositories.GameRepository;
import com.cg.nfl.superbowl.dashboard.backend.repositories.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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
        System.out.println(teamName);
        Team foundTeam = teamRepository.findByTeamName(teamName);
        foundTeam.setGamesPlayed(gameRepository.getByWinnerOrLoserOrderBySbDateDesc(teamName, teamName));
        // - If we had alot of results and needed to return only a few results to work with on the front end
        //foundTeam.setGamesPlayed(gameRepository.findLatestGamesByTeam(teamName, 4));

        return foundTeam;
    }

    @GetMapping("/team/{teamName}/game")
    public Game getGameByYear(@PathVariable String teamName, @RequestParam int year){
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);

        return this.gameRepository.getGamePlayedByYear(teamName, startDate, endDate);
    }

    @GetMapping("/teams")
    public Iterable<Team> getAllTeams(){
        return this.teamRepository.findAll();
    }
}
