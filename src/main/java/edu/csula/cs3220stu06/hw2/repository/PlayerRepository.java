package edu.csula.cs3220stu06.hw2.repository;

import edu.csula.cs3220stu06.hw2.model.Player;
import edu.csula.cs3220stu06.hw2.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Integer> {
List<Player> findByTeam(Integer id);
public int countPlayerByTeam(Integer id);
int countAllByTeam(int team);



}
