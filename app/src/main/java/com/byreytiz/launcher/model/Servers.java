package com.byreytiz.launcher.model;

public class Servers {
    private String name;
    private int players;
    private int maxPlayers;

    public Servers(String name, int players, int maxPlayers) {
        this.name = name;
        this.players = players;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public int getPlayers() {
        return players;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}
