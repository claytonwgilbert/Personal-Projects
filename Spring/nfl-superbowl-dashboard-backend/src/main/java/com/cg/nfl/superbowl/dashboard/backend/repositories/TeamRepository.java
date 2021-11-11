package com.cg.nfl.superbowl.dashboard.backend.repositories;

import com.cg.nfl.superbowl.dashboard.backend.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String name);
}
