package edu.csula.cs3220stu06.hw2.repository;

import edu.csula.cs3220stu06.hw2.model.Player;
import edu.csula.cs3220stu06.hw2.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository  extends CrudRepository<Team,Integer> {


}
