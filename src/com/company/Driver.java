package com.company;

public abstract class Driver implements Comparable<Driver> {
    private String name;
    private String location;
    private Team team;
    int date;
    private int startPosition;
    public int points = 0;

    //default constructor
    Driver(){

    }

    //Overloaded constructor - 1
    Driver(String name){
        this.name = name;
    }

    //Overloaded constructor - 2
    Driver(String name,String location,String team){
     this.name = name;
     this.location = location;
     this.team = new Team(team);
     //Adds the team object to the f1manager array
     Formula1ChampionshipManager.teams.add(this.team);
    }

    public abstract void addPositionsAll();
    public abstract void addPositionSingle(int pos);
    public abstract void setPoints();

    public String getStats(){
        return ("--Driver details--"+"\nName: "+name+"\nLocation: "+location+"\nTeam: "+team.getTeamName());
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return Integer.toString(points);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeamName() {
        return team.getTeamName();
    }

//    get the team object
    public Team getTeam(){return team;}

    @Override
    public int compareTo(Driver f) {
        if(this.points==f.points){
            return 0;
        }
        else if(this.points>f.points){
            return 1;
        }
        else {
            return -1;
        }
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

//    @Override
//    public int compareTo(Formula1Driver f) {
//        if(this.firstPositions== f.getFirstPositions()){
//            return 0;
//        }
//        else if(this.firstPositions>f.getFirstPositions()){
//            return 1;
//        }
//        else {
//            return -1;
//        }
//    }


}
