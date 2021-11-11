package com.cg.nfl.superbowl.dashboard.backend.repositories;

import com.cg.nfl.superbowl.dashboard.backend.model.Game;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    // - Grab all games where team name appears in winner and loser column
    List<Game> getByWinnerOrLoserOOrderBySbDateDesc(String teamNameOne, String teamNameTwo);

    // - 1) Overloaded method for if you had alot of results and wanted to return only a limited view of results.
    List<Game> getByWinnerOrLoserOOrderBySbDateDesc(String teamNameOne, String teamNameTwo, Pageable pageable);

    // - 2) default keyword allows us to have method implementations within an interface. We do this here to keep pageable
    // which is a domain package object separate from our controller. Instead of instantiated pageable in the controller,
    // tightly coupling it, we specify this method here using pageable as a parameter and simply call this method in the
    // controller.
    default List<Game> findLatestGamesByTeam(String teamName, int howManyGames){
        return getByWinnerOrLoserOOrderBySbDateDesc(teamName, teamName, PageRequest.of(0, howManyGames));
    }
}
