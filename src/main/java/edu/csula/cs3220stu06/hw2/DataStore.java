package edu.csula.cs3220stu06.hw2;

import edu.csula.cs3220stu06.hw2.model.Player;
import edu.csula.cs3220stu06.hw2.model.Team;
import org.springframework.stereotype.Component;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataStore {
    private List<Player> players;
    private List<Team> teams;


    public DataStore(){
        this.players = new ArrayList<>();
        this.teams = new ArrayList<>();

        /*players.add(new Player("Tim Apple",1,"M",2012,1));
        players.add(new Player("Tom Hanks",2,"M",2015,3));
        players.add(new Player("Jen",3,"F",2015,4));
        teams.add(new Team(1,"Blue","F",4,12));
        teams.add(new Team(2,"Green","M",4,11));
        teams.add(new Team(3,"Teal","F",4,12));
        teams.add(new Team(4,"Red","M",4,12));*/
    }

    public void addPlayer(Player p){
        players.add(p);
    }
    public void addTeam(Team t){
        teams.add(t);
    }
    public int getYear(){return Year.now().getValue();}


    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public List<Player> getRoster(int n) {
        List<Player> temp = new ArrayList<>();
        for (int i = 0;i<players.size();i++){
            if(players.get(i).getTeam()==n){
                temp.add(players.get(i));
            }
        }
        return temp;
    }


    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public int teamSize(int n){
        int sum = 0;
        for(int i = 0;i< players.size()-1;i++){
            if (teams.get(n-1).getId()==players.get(i).getTeam()){
                sum++;
            }
        }
        System.out.println(players.size());


        return sum;
    }

    public int playersInTeam(int teamID){
        int sum1=0;
        for(int i = 0;i< players.size()-1;i++){
            if(teamID==players.get(i).getTeam()){
               sum1++;
           }
        }
        System.out.println(sum1);


        return sum1;
    }


}
