package com.company;

import java.util.*;

import static com.company.Formula1ChampionshipManager.drivers;

public class Formula1Driver extends Driver {
    //next set a way to add positions to this array
    private ArrayList<Integer> positions = new ArrayList<Integer>();
    protected int firstPositions = 0, secondPositions = 0, thirdPositions = 0, races = 0;


    //Default constructor
    Formula1Driver() {

    }

    //Overloaded constructor calling super class - 1
    Formula1Driver(String name, int noOfRaces) {
        super(name);
        this.races = noOfRaces;
    }

    //Overloaded constructor calling super class - 2
    Formula1Driver(String name, String location, String team, int noOfRaces) {
        super(name, location, team);
        this.races = noOfRaces;
    }

    @Override
    public void addPositionsAll() {
        //Create separate method for position inputs
        Scanner scan = new Scanner(System.in);
        System.out.println("Input driver positions: \n Press Q to quit");
        String user = scan.nextLine();
        user = user.toUpperCase();
        while (true) {
            if (user.equals("Q")) break;
            else {
                try {
                    positions.add(Integer.parseInt(user));
                    System.out.println(Integer.parseInt(user));
                    System.out.println("Input driver positions: \n Press Q to quit");
                    user = scan.nextLine();
                    user = user.toUpperCase();
                } catch (Exception e) {
                    System.out.println("Invalid position");
                }
            }
        }

    }

    @Override
    public void addPositionSingle(int pos){
        positions.add(pos);
    }

    public void addPositionForComplete(int pos) {
        positions.add(pos);
    }

    @Override
    public String getStats() {
        this.setPoints();
        return (super.getStats() + "\nFirst positions: " + firstPositions + "\nSecond positions: " + secondPositions + "\nThird positions: " + thirdPositions + "\nTotal points: " + points);
    }

    //Calculation of points according to the positions array
    public void setPoints() {
        for (int i : positions) {
            if (i == 1){ points += 25; this.setFirstPositions();}
            else if (i == 2){ points += 18; this.setSecondPositions();}
            else if (i == 3){ points += 15;this.setThirdPositions();}
            else if (i == 4) points += 12;
            else if (i == 5) points += 10;
            else if (i == 6) points += 8;
            else if (i == 7) points += 6;
            else if (i == 8) points += 4;
            else if (i == 9) points += 2;
            else if (i == 10) points += 1;
            else points += 0;
        }
    }

    public void setFirstPositions() {
        for (Integer i : positions) {
            if (i == 1) {
                firstPositions += 1;
            }
        }
    }

    public int getFirstPositions() {
        return firstPositions;
    }

    public void setSecondPositions() {
        for (Integer i : positions) {
            if (i == 2) {
                secondPositions += 1;
            }
        }
    }

    public void setThirdPositions() {
        for (Integer i : positions) {
            if (i == 3) {
                thirdPositions += 1;
            }
        }
    }


//    @Override
//    public int compareTo(Formula1Driver f) {
//        if(this.firstPositions==f.firstPositions){
//            return 0;
//        }
//        else if(this.firstPositions>f.firstPositions){
//            return 1;
//        }
//        else {
//            return -1;
//        }
//    }


}
