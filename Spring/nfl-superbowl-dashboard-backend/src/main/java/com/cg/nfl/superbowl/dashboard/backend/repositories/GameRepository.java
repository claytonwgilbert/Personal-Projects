package com.cg.nfl.superbowl.dashboard.backend.repositories;

import com.cg.nfl.superbowl.dashboard.backend.model.Game;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {

    // - What method signature would look like if using Spring data method names to query...too convoluted. Better to
    // switch to @Query annotation
    /*Game getByWinnerAndSbDateBetweenOrLoserAndSbDateBetween(
            String teamNameOne, LocalDate date1, LocalDate date2,
            String teamNameTwo, LocalDate date3, LocalDate date4);*/

    @Query("select g from Game g where (g.winner = :teamName or g.loser = :teamName) and g.sbDate between :yearStart and :yearEnd")
    Game getGamePlayedByYear(
            @Param("teamName") String teamName,
            @Param("yearStart") LocalDate yearStart,
            @Param("yearEnd") LocalDate yearEnd);

    // - Grab all games where team name appears in winner and loser column
    List<Game> getByWinnerOrLoserOrderBySbDateDesc(String teamNameOne, String teamNameTwo);

    // - 1) Overloaded method for if you had alot of results and wanted to return only a limited view of results.
    List<Game> getByWinnerOrLoserOrderBySbDateDesc(String teamNameOne, String teamNameTwo, Pageable pageable);


    // - 2) default keyword allows us to have method implementations within an interface. We do this here to keep pageable
    // which is a domain package object separate from our controller. Instead of instantiated pageable in the controller,
    // tightly coupling it, we specify this method here using pageable as a parameter and simply call this method in the
    // controller.
    default List<Game> findLatestGamesByTeam(String teamName, int howManyGames){
        return getByWinnerOrLoserOrderBySbDateDesc(teamName, teamName, PageRequest.of(0, howManyGames));
    }

}
