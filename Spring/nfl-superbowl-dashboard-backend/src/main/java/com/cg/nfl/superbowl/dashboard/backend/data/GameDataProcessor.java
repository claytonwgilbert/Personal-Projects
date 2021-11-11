package com.cg.nfl.superbowl.dashboard.backend.data;

import com.cg.nfl.superbowl.dashboard.backend.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class GameDataProcessor implements ItemProcessor<GameData, Game> {

    private static final Logger log = LoggerFactory.getLogger(GameDataProcessor.class);

    @Override
    public Game process(final GameData gameData) throws Exception {

        Game game = new Game();
        game.setId(generateGameId());
        game.setSbDate(LocalDate.parse(gameData.getDate(), DateTimeFormatter.ofPattern("MMM d yyyy")));
        game.setSb(gameData.getSb());
        game.setWinner(gameData.getWinner());
        game.setWinnerPts(gameData.getWinner_pts());
        game.setLoser(gameData.getLoser());
        game.setLoserPts(gameData.getLoser_pts());
        game.setMvp(gameData.getMvp());
        game.setStadium(gameData.getStadium());
        game.setCity(gameData.getCity());
        game.setState(gameData.getState());

        log.info("Converting (" + gameData + ") into (" + game + ")");

        return game;
    }

    private UUID generateGameId(){
        return UUID.randomUUID();
    }

}
