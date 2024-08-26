package edu.csula.cs3220stu06.hw2.controller;

import edu.csula.cs3220stu06.hw2.DataStore;
import edu.csula.cs3220stu06.hw2.model.Player;
import edu.csula.cs3220stu06.hw2.model.Team;
import edu.csula.cs3220stu06.hw2.repository.PlayerRepository;
import edu.csula.cs3220stu06.hw2.repository.TeamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@Controller
public class MainController {

    private final PlayerRepository playRepo;
    private final TeamRepository teamRepo;

    public MainController(PlayerRepository pRepo,TeamRepository tRepo){
        this.playRepo=pRepo;
        this.teamRepo=tRepo;
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "root";
    }

    @RequestMapping("/root")
    public String home(){
        return "root";
    }

    @RequestMapping("/players")
    public String player(Model model){
        model.addAttribute("entries",playRepo.findAll());
        return "players";
    }

    @GetMapping("/newPlayer")
    public String newPlayer(Model model){
        model.addAttribute("year", Year.now().getValue());
        return "newPlayer";
    }

    @PostMapping("/newPlayer")
    public String newPlayer(@RequestParam("name") String playerName,
                             @RequestParam("birthYear") int birthYear,
                             @RequestParam("gender") String gender,
                             Model model){
        Player newPlayer = playRepo.save(new Player(playerName,gender,birthYear,0));

        // dataStore.addPlayer(new Player(playerName,dataStore.getPlayers().size()+1,gender,birthYear,0));
        return "redirect:/players";
    }

    @RequestMapping("/teams")
    public String team(Model model){

      model.addAttribute("entries",teamRepo.findAll());
      model.addAttribute("size",playRepo);

        return "teams";
    }


    @RequestMapping("/roster/{id}")
    public String roster(@PathVariable int id, Model model){
       // model.addAttribute("entries",dataStore.getRoster(id));
        model.addAttribute("entries",playRepo.findByTeam(id));

        return "roster";
    }
    @GetMapping("/addTeam")
    public String addTeam(){
        return "addTeam";
    }

    @PostMapping("/addTeam")
    public String addTeam(@RequestParam("color") String color,
                            @RequestParam("min") int min,
                            @RequestParam("max") int max,
                            @RequestParam("gender") String gender,
                            Model model){
       // Player newPlayer = playRepo.save(new Player(playerName,playRepo.findAll().hashCode(),gender,birthYear,0);

        Team newTeam = teamRepo.save(new Team(color,gender,min,max));
       // dataStore.addTeam(new Team(dataStore.getTeams().size()+1,color,gender,min,max));
        return "redirect:/teams";
    }
    @GetMapping("/editPlayer/{id}")
    public String editPlayer(@PathVariable int id, Model model){
       // model.addAttribute("player",dataStore.getPlayers().get(id-1));
        //model.addAttribute("team",dataStore.getTeams());
       // model.addAttribute("year",dataStore.getYear());
        model.addAttribute("player",playRepo.findById(id).get());
        model.addAttribute("team",teamRepo.findAll());
        model.addAttribute("year",Year.now().getValue());

        return "editPlayer";
    }

    @PostMapping("/editPlayer/{id}")
    public String editPlayer(@RequestParam("name") String playerName,
                            @RequestParam("birthYear") int birthYear,
                            @RequestParam("gender") String gender,
                            @RequestParam("team") int team,
                            Model model,
                             @PathVariable int id){
        //dataStore.getPlayers().get(id-1).setGender(gender);
        //dataStore.getPlayers().get(id-1).setName(playerName);
        //dataStore.getPlayers().get(id-1).setBirthYear(birthYear);
        //dataStore.getPlayers().get(id-1).setTeam(team);
        Player edit = playRepo.findById(id).get();
        edit.setGender(gender);
        edit.setName(playerName);
        edit.setBirthYear(birthYear);
        edit.setTeam(team);
        playRepo.save(edit);

        return "redirect:/players";
    }




}
