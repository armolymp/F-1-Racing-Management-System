package com.company;

import java.util.ArrayList;

public interface ChampionshipManager {
    public abstract void createDriver(String name,String location,String team,int noOfRaces);
    public abstract void deleteDriverAndTeam(String name,String team);
    public  abstract void changeDriverInTeam(String name,String team);
    public abstract void driverTable();
    public abstract void saveData();
}
