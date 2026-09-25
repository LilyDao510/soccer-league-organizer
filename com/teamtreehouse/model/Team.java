package com.teamtreehouse.model;
import java.util.HashSet;
import java.util.Set;

// the Team class
// Stores the team name and the coach name
// players is a Set -> duplicate players are blocked automatically

public class Team implements Comparable<Team> {
    // REQUIREMENT 1: at most 11 players per team (shared constant)
    public static final int MAX_PLAYERS = 11;

    private String teamName;
    private String coachName;
    private Set<Player> players;

    public Team(String teamName, String coachName) {
        this.teamName = teamName;
        this.coachName = coachName;
        this.players = new HashSet<>();
    }
    public String getTeamName() {
        return teamName;
    }
    public String getCoachName() {
        return coachName;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    // REQUIREMENT 1: checks whether the team already has 11 players
    public boolean isFull() {
        return players.size() >= MAX_PLAYERS;
    }

    // adds a player to the team
    // Returns false when the team is full (LeagueManager reports it)
    // Set.add returns false if the player is already on the team
    public boolean addPlayer(Player player) {
        if (isFull()) {
            return false;
        }

        return players.add(player);
    }

    // removes a player from the team
    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    @Override
    public int compareTo(Team other) {
        return teamName.compareToIgnoreCase(other.getTeamName());
    }
}