import java.io.IOException;

public class Practice extends Dirtbike {

    // this holds the time in hours for the exact time when the parts need to be replaced.
    int driveChainChange = 8;
    int airFilterChange = 2;
    int tireChange = 10;
    int brakePadChange = 8;

    //the practice menu is just the menu that will be pulled up for the user to interact with.
    public void PracticeMenu() throws IOException{
        System.out.println("Welcome to the Practice dirtbike menu");

        boolean keepGoing = true;
        while(keepGoing){
            printDirtbike();

            System.out.println();
            System.out.println("Dirtbike Menu");
            System.out.println("Choose one of the options below");
            System.out.println("0) Exit");
            System.out.println("1) Add seat time");
            System.out.println("2) Replace a part");
            System.out.println("3) Check status of a part");
            System.out.println("4) Check status on all parts");
            System.out.println("What would you like to do?  ");
            String choice = input.nextLine();

            if (choice.equals("0")){
                deleteOld();
                saveChanges();
                keepGoing = false;
            }
            else if (choice.equals("1")){
                addTime();
                splitData();
                UpdateAllParts();
                splitData();
            }
            else if (choice.equals("2")){
                replacePart();
                UpdateAllParts();
                splitData();
                
            }
            else if (choice.equals("3")){
                onePart();
                UpdateAllParts();
                splitData();
            }
            else if (choice.equals("4")){
                allPartsStatus();
            }
            else{
                System.out.println("I don't understand");
            }
        }
    }

    //this will update the statuses of each part and send it back to be re evaluated.
    public String UpdateAllParts(){
        //checks all the parts and commits the new statuses of each part

        //first were gonna check the airfilter.
        int a = Integer.parseInt(airfilterTime);
        if(a >= airFilterChange){
            airfilterStatus = "Replace";
        }
        else if(a == 0){
            airfilterStatus = "New";
        }
        else if(a == 1){
            airfilterStatus = "Okay";
        }

        //next were gonna check the drive chain
        int b = Integer.parseInt(drivechainTime);
        if(b >= driveChainChange){
            drivechainStatus = "Replace";
        }
        else if(b == 0){
            drivechainStatus = "New";
        }
        else if(b < driveChainChange){
            drivechainStatus = "Okay";
        }

        //then we change the tire
        int c = Integer.parseInt(tiresTime);
        if(c >= tireChange){
            tiresStatus = "Replace";
        }
        else if(c == 0){
            tiresStatus = "New";
        }
        else if(c < tireChange){
            tiresStatus = "Okay";
        }

        //then we change the brake pads
        int d = Integer.parseInt(brakepadTime);
        if(d >= brakePadChange){
            brakepadStatus = "Replace";
        }
        else if(d == 0){
            brakepadStatus = "New";
        }
        else if(d < brakePadChange){
            brakepadStatus = "Okay";
        }

        //now we pass this back as a string to be re split back up for more interaction.
        String e = fName + "," + lName + "," + type + "," + manufacturer + "," + model + "," + year + "," + frameTime + "," + airfilterTime + "," + airfilterStatus + "," + drivechainTime + "," + drivechainStatus + "," + tiresTime + "," + tiresStatus + "," + brakepadTime + "," + brakepadStatus + ",";

        data = e;
        return data;
    }

    //this will provide a deeper analysis into a specific part status.
    public void onePart(){
        Boolean keepGoing = true;

        while(keepGoing){
            try{
                System.out.println();
                System.out.println("Which of the following parts would you like to see an in depth analysis of?");
                System.out.println("A) Airfilter");
                System.out.println("B) Drive Chain");
                System.out.println("C) Tires");
                System.out.println("D) Brake Pads");
                System.out.println("Please enter the letter of the part you would like to replace.");
                String a = input.nextLine();
                a = a.toUpperCase();
                System.out.println();

                if (a.equals("A")){
                    System.out.println("The air filter has " + airfilterTime + " hours on it currently.");
                    System.out.println("The status as of right now is " + airfilterStatus);
                    int aa = Integer.parseInt(airfilterTime);
                    int ab = airFilterChange - aa;

                    if(ab > 0){
                        System.out.println("You have " + ab + " hours until your next replacement.");
                    }
                    else if(ab <= 0){
                        System.out.println("Your replacement is overdue");
                    }
                    keepGoing = false;
                }
                else if(a.equals("B")){

                    System.out.println("The drive chain has " + drivechainTime + " hours on it currently.");
                    System.out.println("The status as of right now is " + drivechainStatus);
                    int ba = Integer.parseInt(drivechainTime);
                    int bb = driveChainChange - ba;

                    if(bb > 0){
                        System.out.println("You have " + bb + " hours until your next replacement.");
                    }
                    else if(bb <= 0){
                        System.out.println("Your replacement is overdue.");
                    }
                    keepGoing = false;

                }
                else if(a.equals("C")){
                    System.out.println("The tire set has " + tiresTime + " hours on it currently.");
                    System.out.println("The status as of right now is " + tiresStatus);
                    int ca = Integer.parseInt(tiresTime);
                    int cb = tireChange - ca;

                    if(cb > 0){
                        System.out.println("You have " + cb + " hours until your next replacement.");
                    }
                    else if(cb <= 0){
                        System.out.println("Your replacement is overdue");
                    }
                    keepGoing = false;

                }
                else if(a.equals("D")){
                    System.out.println("The brake pad set has " + brakepadTime + " hours on it currently.");
                    System.out.println("The status as of right now is " + brakepadStatus);
                    int da = Integer.parseInt(brakepadTime);
                    int db = airFilterChange - da;

                    if(db > 0){
                        System.out.println("You have " + db + " hours until your next replacement.");
                    }
                    else if(db <= 0){
                        System.out.println("Your replacement is overdue");
                    }
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
    
    }

    //The Practice, Modified, and Stock abstract classes are going to look similar but with small changes in the varaibles at the beginning where the times of replacement will be different.

}
