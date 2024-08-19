package com.company;

import javax.swing.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void menu(){
        System.out.println(" C- create driver\n D- delete driver\n X- Complete race\n S- change driver for a team\n P- print stats of a driver\n T- print driver table\n A- save data to file \n L- Load data from file\n G- Start GUI \n Q- Quit");
    }

    public static void main(String[] args) {
   Formula1ChampionshipManager manager = new Formula1ChampionshipManager();

        Scanner scan = new Scanner(System.in);

        while (true){
            System.out.println("-- Welcome to the Formula one driver Manager --\n What do you wanna do?");
            menu();
            String input = scan.nextLine().toUpperCase(Locale.ROOT);
            if(input.equals("C")){
                System.out.println("Input driver name: ");
                String name = scan.nextLine();
                System.out.println("Input location: ");
                String location = scan.nextLine();
                System.out.println("Input Team: ");
                String team = scan.nextLine();
                System.out.println("Input no of races");
                int races = scan.nextInt();
                scan.nextLine();
                manager.createDriver(name,location,team,races);
                manager.driverTable();
                System.out.println("Driver added successful");
            }
          else if(input.equals("D")){
              System.out.println("Input the driver name to delete: ");
              String name = scan.nextLine();
              System.out.println("Input the team to delete: ");
              String team = scan.nextLine();
              manager.deleteDriverAndTeam(name,team);

            }
          else if(input.equals("S")){
                System.out.println("Team name you wish to change driver: ");
                String team = scan.nextLine();
                System.out.println("Name of the new driver: ");
                String name = scan.nextLine();
                manager.changeDriverInTeam(name,team);
                System.out.println("Driver change successful for team "+team);
            }
          else if(input.equals("P")){
                System.out.println("Type a name of the driver you wish to see stats: ");
                String name = scan.nextLine();
                manager.checkStats(name);
            }
          else if(input.equals("T")){
              manager.printDriverTable();
            }
          else if(input.equals("F")){
              manager.completeRace();
            }
          else if(input.equals("X")){
              manager.completeRace();
            }
          else if(input.equals("A")){
              manager.saveData();
            }
          else if(input.equals("L")){
              manager.loadData();
            }
          else if(input.equals("Q")){
              break;
            }
          else if(input.equals("G")){
              new Formula1Gui();
            }
          else{
                System.out.println("Invalid input");
                System.out.println(input);
            }
        }


    }
}
