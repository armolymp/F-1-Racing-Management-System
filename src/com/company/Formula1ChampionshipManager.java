package com.company;

import java.io.*;
import java.util.*;

public class Formula1ChampionshipManager implements ChampionshipManager {
    //This arraylist all driver instances
    protected static ArrayList<Driver> drivers = new ArrayList<Driver>();
    protected static ArrayList<Team> teams = new ArrayList<Team>();
    static String[][] table = new String[20][4];


    Formula1ChampionshipManager(){

    }

//    Create and adding new driver to arraylist
    @Override
    public void createDriver(String name,String location,String team,int noOfRaces) {
        Driver obj = new Formula1Driver(name,location,team,noOfRaces);
        drivers.add(obj);
    }

    @Override
    public void deleteDriverAndTeam(String name,String teamName) {
        for (int i = 0; i <drivers.size()-1; i++) {
            if(name.equals(drivers.get(i).getTeamName())){
                drivers.remove(i);
                System.out.println("Driver deleted");
            }
            else System.out.println("Driver not found");
        }

        for (int i = 0;i<teams.size()-1;i++){
            if(teamName.equals(teams.get(i).getTeamName())){
                drivers.remove(i);
                System.out.println("Team deleted");
            }
            else System.out.println("Team not found");
        }
    }

    @Override
    public void changeDriverInTeam(String name, String team) {
        for(int i =0;i<drivers.size()-1;i++){
            if(team.equals(drivers.get(i).getTeamName())){
               drivers.get(i).setName(name);
               break;
            }
            else System.out.println("Team not found");
        }
    }

    public void checkStats(String name){
        for (Driver d:drivers) {
            if(d.getName().equals(name)){
                System.out.println(d.getStats());
            }
            else System.out.println("Driver not found");
        }
    }

    //updates driver table
    @Override
    public void driverTable() {
        Collections.sort(drivers);

        for (int i = 0;i< drivers.size()-1;i++) {
            table[i][0] = drivers.get(i).getName();
            table[i][1] = drivers.get(i).getTeamName();
            table[i][2] = drivers.get(i).getLocation();
            table[i][3] = drivers.get(i).getPoints();
        }

    }

    public void sortByFirstPositions(){
       Collections.sort(drivers);
    }


    public void printDriverTable(){
        driverTable();
        System.out.println("Driver Team Location Points");
        for (String[] row : table)
            System.out.println(Arrays.toString(row));
    }

    public void completeRace(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Adding race stats - please enter the team name: ");
        String teamName = scan.nextLine();
        for (Driver i:drivers) {
            if(i.getTeamName().equals(teamName)){
                System.out.println("Add position of Driver"+i.getName()+"for team"+i.getTeamName());
                int pos = scan.nextInt();
                Formula1Driver x = (Formula1Driver) i;
                x.addPositionForComplete(pos);
                System.out.println("Day of the race (Integer)");
                int day = scan.nextInt();
                x.date = day;
            }
            else System.out.println("Team not found");
        }
    }

    public void sortByPoints(){
        Collections.sort(drivers);
    }

    public void saveData() {

        try {
            FileWriter fw = new FileWriter("file1.txt");
            PrintWriter pw = new PrintWriter(fw);
            for (Driver d:drivers) {
                String text = d.getName()+"\n"+d.getTeamName()+"\n"+d.getLocation()+"\n"+d.getPoints();
                pw.println(text);
            }
            System.out.println("Saved to file");
            pw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loadData(){
        try {
            File myObj = new File("file1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()){
                 for(int i = 0;i<20;i++){
                     for(int j = 0;j<1;j++){
                         table[i][j] = myReader.nextLine();
                         table[i][j+1] = myReader.nextLine();
                         table[i][j+2] = myReader.nextLine();
                         table[i][j+3] = myReader.nextLine();
                     }
                 }
            }
            System.out.println("Data loaded to driver table");

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public static String[][] getArray(){
        return table;
    }

    public void randomRace(){
        for (Driver i:drivers) {
            int x = (int)(Math.random()*(10-1+1)+1);
            i.addPositionSingle(x);
            System.out.println(x);
            i.setPoints();
            this.driverTable();
        }
    }

    public void randomStart(){
        for (Driver i:drivers) {
            int x = (int)(Math.random()*(10-1+1)+1);
            i.setStartPosition(x);
            System.out.println(x);
        }
    }
}
