import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Dirtbike {
    //create an instance of the main function to use in the abstract class and input a scanner.
    Main m = new Main();
    Scanner input = new Scanner(System.in);

    //These are the variables of each part of the data being brough in from the string.
    String data;
    String fName;
    String lName;
    String type;
    String manufacturer;
    String model;
    String year;
    String frameTime;
    String airfilterTime;
    String airfilterStatus;
    String drivechainTime;
    String drivechainStatus;
    String tiresTime;
    String tiresStatus;
    String brakepadTime;
    String brakepadStatus;

   
    public void printDirtbike(){
        splitData();
        //prints out the dirtbike data to the user.
        System.out.println();
        System.out.println("Owner: " + fName + " " + lName);
        System.out.println("Type: "+ type);
        System.out.println("Manufacturer: "+ manufacturer);
        System.out.println("Model: "+ model);
        System.out.println("Year: "+ year);
        System.out.println("Time on frame: "+ frameTime);
        System.out.println("Time on current brake set: " + brakepadTime);
        System.out.println("Time on current airfilter: "+ airfilterTime);
        System.out.println("Time on current drive chain: "+ drivechainTime);
        System.out.println("Time on current tire set: "+ tiresTime);
    }
    
    public void splitData(){
        //This method will split up the data and pass it back to the varaibles to be used again.
        String temp[] = data.split(",");

        fName = temp[0];
        lName = temp[1];
        type = temp[2];
        manufacturer = temp[3];
        model = temp[4];
        year = temp[5];
        frameTime = temp[6];
        airfilterTime = temp[7];
        airfilterStatus = temp[8];
        drivechainTime = temp[9];
        drivechainStatus = temp[10];
        tiresTime = temp[11];
        tiresStatus = temp[12];
        brakepadTime = temp[13];
        brakepadStatus = temp[14];

    }

    public String loadDirtbike(){
        //loads the string that contains a single dirtbike into the abstract class
        String bike = m.getRequestBike();
        data = bike;
        return data;
    }

    public String addTime(){
        //Asks the user to input the amount of time the user rode in hours.
        System.out.println();
        System.out.println("How many hours did you put on the Dirtbike? ");
        String time = input.nextLine();
        System.out.println("Input Hours" + time);

        //below is the adding on the new time to the old time for each part. 

        //adding to frame time
        int a = Integer.parseInt(time);
        int b = Integer.parseInt(frameTime);
        int c = a + b;
        String d = String.valueOf(c);
        frameTime = d;

        //adding to airfilter time
        int e = Integer.parseInt(airfilterTime);
        int f = a + e;
        String g = String.valueOf(f);
        airfilterTime = g;

        //adding time to drive chain
        int h = Integer.parseInt(drivechainTime);
        int i = a + h;
        String j = String.valueOf(i);
        drivechainTime = j;

        //adding time to tire time
        int k = Integer.parseInt(tiresTime);
        int l = a + k;
        String m = String.valueOf(l);
        tiresTime = m;

        //adding time to brake pads
        int n = Integer.parseInt(brakepadTime);
        int o = a + n;
        String p = String.valueOf(o);
        brakepadTime = p;

        //create a new string containing the updated stuff and send it back to the class.
        String updatedData = fName + "," + lName + "," + type + "," + manufacturer + "," + model + "," + year + "," + frameTime + "," + airfilterTime + "," + airfilterStatus + "," + drivechainTime + "," + drivechainStatus + "," + tiresTime + "," + tiresStatus + "," + brakepadTime + "," + brakepadStatus + ",";
        data = updatedData;

        return data;
    }

    public void saveChanges() throws IOException{
        //saves a new string of data and adds it back to the race text file.
        String UpdatedBike = fName + "," + lName + "," + type + "," + manufacturer + "," + model + "," + year + "," + frameTime + "," + airfilterTime + "," + airfilterStatus + "," + drivechainTime + "," + drivechainStatus + "," + tiresTime + "," + tiresStatus + "," + brakepadTime + "," + brakepadStatus + ",";

        BufferedWriter output = new BufferedWriter(new FileWriter("RaceTeam.txt", true));
        output.append(UpdatedBike); //starts a new line and then adds the new bike
        output.close(); 
    }

    public void allPartsStatus(){
        
        //This will use print statements to print out the current status of each part.
        System.out.println();
        System.out.println("Below are the current status for the parts on your Dirtbike");
        System.out.println();
        System.out.println("The current time on the air filter is " + airfilterTime + " hours");
        System.out.println("Airfilter Status: " + airfilterStatus);
        System.out.println("The current time on the drive chain is " + drivechainTime + " hours");
        System.out.println("Drive chain Status: " + drivechainStatus);
        System.out.println("The current time on the tire set is " + tiresTime + " hours");
        System.out.println("Tire status: " + tiresStatus);
        System.out.println("The current time on the brake pad set is " + brakepadTime + " hours");
        System.out.println("Brake pad Status: " + brakepadStatus);
    }

    public String replacePart(){
        //this will replace a certain part to a new part.

        Boolean keepGoing = true;

        while(keepGoing){
            try{
                System.out.println();
                System.out.println("Which of the following parts would you like to replace?");
                System.out.println("A) Airfilter");
                System.out.println("B) Drive Chain");
                System.out.println("C) Tires");
                System.out.println("D) Brake Pads");
                System.out.println("Please enter the letter of the part you would like to replace.");
                String a = input.nextLine();
                a = a.toUpperCase();

                if (a.equals("A")){
                    airfilterTime = "0";
                    keepGoing = false;
                }
                else if(a.equals("B")){
                    drivechainTime = "0";
                    keepGoing = false;
                }
                else if(a.equals("C")){
                    tiresTime = "0";
                    keepGoing = false;
                }
                else if(a.equals("D")){
                    brakepadTime = "0";
                    keepGoing = false;
                }
                else{
                    System.out.println("It seems you've input a invalid character");
                    System.out.println("Please try again");
                }
            } catch(Exception e){
                System.out.println("I dont understand what happened. Please help.");
            }
        }
        String replacedData = fName + "," + lName + "," + type + "," + manufacturer + "," + model + "," + year + "," + frameTime + "," + airfilterTime + "," + airfilterStatus + "," + drivechainTime + "," + drivechainStatus + "," + tiresTime + "," + tiresStatus + "," + brakepadTime + "," + brakepadStatus + ",";
        data = replacedData;
        return data;
    }

    public void deleteOld() throws IOException{

        // this method will delete the old data saved in the text file of the users dirtbike which has now been manipulated in the dirtbike menu.


        String old = m.getRequestBike(); //get the old data before manipulation.
        File currentFile = new File("RaceTeam.txt"); //get the race team file 
        File tempFile = new File("Temp.txt"); //create a temporary file.

        BufferedReader br = new BufferedReader(new FileReader(currentFile)); //get a buffered reader to read through the text file
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile)); //get a buffered writer to start writing things into the new temporary file

        String lineToRemove = old; //get the old data and add it to a new string
        String currentLine;

        //this will loop through the race team file and add the contents into the new temporary file except the string file that matches the old data.
        while((currentLine = br.readLine()) != null){
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineToRemove)) continue;
            bw.write(currentLine + "\n");
        }
        bw.close();
        br.close();
        tempFile.renameTo(currentFile); //rename the temporary file to the raceteam file.
    }

}
