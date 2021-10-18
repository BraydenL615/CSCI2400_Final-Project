import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    //This class serves as the main hub for the program to run in.
    //It houses the main menu where the user will originally be brought to upon first loading of the program.


    public static void main(String[] args) throws IOException{
        //This is the main run function which will run everything in these brackets when the program is booted up.

        //Below are the 3 different types of dirtbikes that are involved in the program. 
        //So, we get instances of these classes upon starting the program.
        Practice p = new Practice();
        Modified mod = new Modified();
        Stock stock = new Stock();
        System.out.println("Welcome to the Race Team Maintenance Program"); //This just prints out a basic welcome for the user.

        boolean keepGoing = true; 

        //Below is a loop that will continue looping around until the user to be able to interact with the program for as long as they want without the program ending.
        while(keepGoing){


            System.out.println(); //Print out a couple empty lines to prevent cramping in the terminal.
            System.out.println();

            //Below is the menu of options the user can selecet from.
            System.out.println("Main Menu");
            System.out.println("Choose one of the options below");
            System.out.println("0) Exit");
            System.out.println("1) Add a new Dirtbike");
            System.out.println("2) Work on a single Dirtbike");
            System.out.println("3) Check status for whole race team");
            String choice = s.nextLine();

            //Below are the statements to get the user exactly which method they need depending on which input they put in the input.
            if (choice.equals("0")){
                System.out.println();
                System.out.println("Thanks for interacting with my program.");
                System.out.println("-Brayden Lomax");
                s.close();
                input.close();
                keepGoing = false;
            }
            else if (choice.equals("1")){
                System.out.println();
                addNewDirtbike();
                saveRaceTeam();
                System.out.println("Your new dirtbike has been added"); //Just a little message to the user so they can know their new bike has successfully been added.
            }
            else if (choice.equals("2")){
                loadRaceTeam();
                printWholeRaceTeam();
                FindBike();
                sortType();
                if (findType.equals("Practice")){
                    p.loadDirtbike();
                    p.PracticeMenu();
                }
                else if (findType.equals("Modified")){
                    mod.loadDirtbike();
                    mod.ModifiedMenu();
                }
                else if (findType.equals("Stock")){
                    stock.loadDirtbike();
                    stock.StockMenu();
                }

            }
            else if (choice.equals("3")){
                System.out.println();
                loadRaceTeam();
                printWholeRaceTeam();
            }
            else {
                System.out.println("I don't understand");
            }
        }
    }


    //Below is a list of variables and a Scanner that will be used in the main class by its methods.
    static Scanner s = new Scanner(System.in);
    static ArrayList<String> team; //a variable to hold the arraylist of the whole raceteam.
    static String requestDirtbike;
    static String newDirtBike;
    static Scanner input = new Scanner(System.in);
    static String findType;


    public static ArrayList<String> loadRaceTeam() throws FileNotFoundException{
        Scanner s = new Scanner(new File("RaceTeam.txt")); //brings in a scanner so we can bring in the data from the text file
        ArrayList<String> list = new ArrayList<String>();
        while(s.hasNextLine()){ //creates a loop to loop through as long as there is still stuff in the text file
            list.add(s.next()); //adds the line of dirtbikes into the arraylist 
        }

        team = list; //sets the arraylist to a value in the class to be used later;
        return team; //sends the collected data back to the functions.
    }

    public static void printWholeRaceTeam(){
        for(int i = 0; i < team.size(); i++){ //create a for loop to loop through as many times as there are dirtbikes
            String temp = team.get(i); //grabs the dirtbike into a temp string file 
            String[] details = temp.split(","); //uses this to split up the data into its respective chunks.

            String FName = details[0];
            String LName = details[1];
            String type = details[2];
            String manufacturer = details[3];
            String model = details[4];
            String year = details[5];
            String frameTime = details[6];
            String filter = details[8];
            String driveChain = details[10];
            String tires = details[12];
            String brakepad = details[14];
            //The lines above give the respective split up values a home to be passed into a print out statement

            System.out.println();
            System.out.println("Current Lineup Number: " + i);
            System.out.println("Owner: " + FName + " " + LName);
            System.out.println("Type: " + type);
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Model: " + model);
            System.out.println("Year: " + year);
            System.out.println("Current Frame Time: " + frameTime);
            System.out.println("Current Air Filter Status: " + filter);
            System.out.println("Current Drive Chain Status: " + driveChain);
            System.out.println("Current Tire Status: " + tires);
            System.out.println("Current Brake Pad Status: " + brakepad);
            System.out.println();
            //the code above is a generic format that will be used to show off the lineup to the user
        }
    }

    public static void saveRaceTeam() throws IOException{
        //this method will save the curent arraylist back to the file.
        BufferedWriter output = new BufferedWriter(new FileWriter("RaceTeam.txt", true));
        output.append("\n" + newDirtBike); //starts a new line and then adds the new bike
        output.close(); 
    }

    public static String addNewDirtbike() throws IOException{
        //Give the user a new opportunity to add a new ditbike to the maintenance tracker.

        Boolean keepGoing = true;
        System.out.println();
        System.out.println("What is the first name of the owner?");
        String newFName = input.nextLine();
        System.out.println("What is the last name of the owner?");
        String newLName = input.nextLine();
        String newType = "";
        while(keepGoing){
            try{
                System.out.println("Is your Dirtbike:");
                    System.out.println("A) Stock Bike");
                    System.out.println("B) Modified Bike");
                    System.out.println("C) Practice Bike");
                    System.out.println("Please enter the letter corresponding with your dirbike");
                    String a = input.nextLine();
                    a = a.toUpperCase();
    
                    if(a.equals("A")){
                        newType = "Stock";
                        keepGoing = false;
                    }
                    else if(a.equals("B")){
                        newType = "Modified";
                        keepGoing = false;
                    }
                    else if(a.equals("C")){
                        newType = "Practice";
                        keepGoing = false;
                    }
                    else{
                        System.out.println("It seems you've input a invalid character.");
                        System.out.println("Please try again.");
                    }
                } catch(Exception e){
                    System.out.println("It seems there has been an error. My bad");
            }
        }
        System.out.println();
        System.out.println("What Manufacturer is your Dirtbike?");
        String newManufacturer = input.nextLine();
        System.out.println();
        System.out.println("What Model is the Dirtbike?");
        String newModel = input.nextLine();
        System.out.println("What Year is the Dirtbike?");
        String newYear = input.nextLine();

        //We add the new string of data for the dirtbike to be addeed back into the RaceTeam file.
        newDirtBike = newFName + "," + newLName + "," + newType + "," + newManufacturer + "," + newModel + "," + newYear + "," + "0" + "," + "0" + "," + "New" + "," + "0" + "," + "New" + "," + "0" + "," + "New" + "," + "0" + "," + "New" + ",";

        return newDirtBike;
    }

    public static String FindBike() throws IOException{
        //This will give the user a method to find a specific dirtbike in the raceteam file.

        //we will continue looping until a valid dirtbike id is given.
        Boolean keepGoing = true;
        while(keepGoing){
            try{
                System.out.println();
                System.out.println("What is the current lineup number on the bike you would like to work on?");
                String b = input.nextLine();

                for(int i = 0; i < team.size(); i++){
                    int a = Integer.parseInt(b);
                    if(a == i){
                        requestDirtbike = team.get(a);
                        keepGoing = false;
                        break;
                    }
                    else if (a > team.size()){
                        System.out.println("It seems like that number is not currently being used.");
                        System.out.println("Please try again.");
                        break;
                    }
                }
            } catch(Exception e){
                System.out.println("An exception was caught. Try again"); // a catch block to catch exceptions.
            }
        }

        return requestDirtbike;  //We return the request bike back to the main funciton.
    }

    public String getRequestBike(){
        //a get method to get the string that contatins the data of the specific dirtbike the user wants to interact with.
        return requestDirtbike;
    }

    public static void sortType(){
        //This method will sort the string of data for the specific dirtbike the user wants it to use and put it into an array then we can
        //figure out which type of dirtbike it is then send that result back to the main function.

        String temp = requestDirtbike;

        String splitter[] = temp.split(",");

        findType = splitter[2];
    }


}