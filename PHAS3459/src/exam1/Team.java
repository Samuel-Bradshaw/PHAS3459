package exam1;

import java.util.ArrayList;

public class Team {

	ArrayList<BaseballPlayer> teamplayers = new ArrayList<BaseballPlayer>();
	String teamName;

	//Constructor which takes the Team name and the player name as arguments and adds the 
	//player to the ArrayList of players that make up the team:
	Team(String name, BaseballPlayer player){
		teamName = name;
		teamplayers.add(player);
	}

	void addPlayer(BaseballPlayer player){
		teamplayers.add(player);
	}

	public ArrayList<BaseballPlayer> getPlayers(){
		return teamplayers;
	}

	public String getName(){
		return teamName;
	}

	//presents data in readable form
	public String toString(){
		String teamString = "";
		for(BaseballPlayer player : teamplayers){
			teamString = player+"";
		}
		return teamString;
	}

}
