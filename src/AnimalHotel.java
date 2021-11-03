import java.util.*;

public class AnimalHotel {

    Animal currentAnimalObj;
    ArrayList<Animal> guests = new ArrayList<Animal>();//Array list of animal class
    ArrayList<Room> guestRooms = new ArrayList<Room>();//Array list of Room class
    String animal;


    public void start() {

        boolean programRunning = true;

        //Creating 6 rooms of 3 different kinds, and adding them to an Array
        Room marineRoom1 = new MarineRoom("MarineRoom1", " dimensions",  1, false);
        Room marineRoom2 = new MarineRoom("MarineRoom2", " dimensions",  2, false);
        guestRooms.add(marineRoom1);
        guestRooms.add(marineRoom2);

        Room groundRoom1 = new GroundRoom("Groundroom1", "dimensions", 3, false);
        Room groundRoom2 = new GroundRoom("Groundroom2", "dimensions", 4, false);
        guestRooms.add(groundRoom1);
        guestRooms.add(groundRoom2);

        Room arialRoom1 = new ArialRoom("ArialRoom1", "dimensions",  5, false);
        Room arialRoom2 = new ArialRoom("ArialRoom2", "dimensions",  6, false);
        guestRooms.add(arialRoom1);
        guestRooms.add(arialRoom2);

        //While loop that as long as (true) keeps the program running
        while (programRunning) {
            // Prints the Main menu, and lets the user select an option that represents what the user wants to do.
            mainMenu();
            int userChoice = getUserInt();

            //Switch-Case that depending on what the user choose in previous step calls on another method
            switch (userChoice) {

                case 1:
                    checkIn();
                    break;

                case 2:
                    checkOut();
                    break;

                case 3:
                    editBookings();
                    break;

                case 4:
                    listBookings();
                    break;

                case 5:
                    individualBookingDetails();
                    break;

                case 6:
                    filterBookings();
                    break;

                case 7:
                    programRunning = false;
                    System.out.println("Shutting Down...");
                    break;

                default:
                    System.out.println("You have entered a wrong option. Please select again.");

            }
        }
    }

    public void mainMenu() {

        System.out.println("[1] Check in guest");
        System.out.println("[2] Check out guest");
        System.out.println("[3] Edit bookings");
        System.out.println("[4] List bookings");
        System.out.println("[5] Individual booking details");
        System.out.println("[6] Search among bookings");
        System.out.println("[7] Exit program");
        System.out.print("[?]> ");

    }

    public void checkIn() {
        int animalChoice;

        do {
            System.out.println("What kind of animal are you?");
            System.out.println("[1] Orca");
            System.out.println("[2] Cheetah");
            System.out.println("[3] Peregrine falcon");
            System.out.print("> ");
            animalChoice = getUserInt();


            switch (animalChoice) {

                case 1:
                    animal = "orca";
                    break;

                case 2:
                    animal = "cheetah";
                    break;

                case 3:
                    animal = "peregrinefalcon";
                    break;

                default:
                    System.out.println("You have entered a wrong option. Please select again.");

            }
        } while(animalChoice <  1 || animalChoice > 3);


        System.out.println("What is your name?");
        System.out.print("> ");
        String name = getUserString();

        System.out.println("What is your favorite activity?");
        System.out.print("> ");
        String favoriteActivity = getUserString();

        System.out.println("What is your favorite food?");
        System.out.print("> ");
        String favoriteFood = getUserString();


        if (animal.equals("orca")) {

            Orca orca = new Orca(name, favoriteActivity, favoriteFood);
            guests.add(orca);
            currentAnimalObj = orca;

        } else if (animal.equals("cheetah")) {

            Cheetah cheetah = new Cheetah(name, favoriteActivity, favoriteFood);
            guests.add(cheetah);
            currentAnimalObj = cheetah;

        } else if (animal.equals("peregrinefalcon")) {

            PeregrineFalcon peregrineFalcon = new PeregrineFalcon(name, favoriteActivity, favoriteFood);
            guests.add(peregrineFalcon);
            currentAnimalObj = peregrineFalcon;
        }

        while (true) {

            boolean roomchoice=true;

            System.out.println("Available Rooms              Description");
            System.out.println("----------------------------------------");

            //Prints all rooms in the hotel Which are available

            int numOfBookedRooms=0;

            for (int i = 0; i < guestRooms.size(); i++) {

                if(!guestRooms.get(i).getIsBooked()) {

                    System.out.printf("[%-1d]%-26s%s\n",(i+1), guestRooms.get(i).getRoomName(), guestRooms.get(i).describe());

                    numOfBookedRooms++;
                }
            }
            if(numOfBookedRooms==0) {

                System.out.println("No rooms are available.");

                break;

            }else {
                System.out.println("> ");
                int userChoice = getUserInt();
                try{
                if(guestRooms.get(userChoice - 1).getIsBooked()) {

                    System.out.println("This room is already booked, please select rooms from list of availble rooms");
                }

                else {

                    guestRooms.get(userChoice - 1).setGuests(currentAnimalObj);
                    System.out.println("Room number " + guestRooms.get(userChoice - 1).getRoomNumber() + " is booked on the name of " + guestRooms.get(userChoice - 1).getGuests().getName());
                    guestRooms.get(userChoice - 1).setIsBooked(true);

                    break;
                }
                }
                catch( Exception e){
                    System.out.println("Faulty Input");

                }
            }
        }
    }
    public void checkOut() {
        listBookings();
        System.out.println("Enter the room number to Chekingout");
        System.out.print("> ");
        Integer checkoutroom = getUserInt();
        String checkoutname = null;

        for (int i = 0; i < guestRooms.size(); i++) {

            if (guestRooms.get(i).getIsBooked()) {

                if (checkoutroom == guestRooms.get(i).getRoomNumber()) {
                    checkoutname = guestRooms.get(i).getGuests().getName();
                    //guestRooms.remove(checkoutname);
                    guests.remove(checkoutname);
                    System.out.println(checkoutname + "is checked out");
                    guestRooms.get(i).setGuests(null);
                    guestRooms.get(i).setIsBooked(false);

                }
            }
        }
    }

    public void listBookings() {

        System.out.printf("Name                 Roomnumber\n");
        System.out.println("-------------------------------");

        for (int i = 0; i < guestRooms.size(); i++) {

            if (guestRooms.get(i).getIsBooked()) {

                System.out.printf("%-19s%d\n", guestRooms.get(i).getGuests().getName(), guestRooms.get(i).getRoomNumber());
            }
        }
    }

    public void editBookings() {
        listBookings();

        System.out.println("Enter the room number that you would like to edit the details");
        System.out.print("> ");
        int userChoice1 = getUserInt();

        for (int i = 0; i < guestRooms.size(); i++) {

            if (userChoice1==guestRooms.get(i).getRoomNumber()) {

                System.out.println("What would you like to change?");
                System.out.println("1. Change name");
                System.out.println("2. Change Favorite Activity");
                System.out.println("3. Change Favorite Food");
                System.out.print("> ");
                int userinput = getUserInt();

                //This if-method changes the guests name if the user input is == 1
                if (userinput == 1) {

                    System.out.println("What would you like to change your name to?");
                    System.out.print("> ");
                    String userChoice = getUserString();

                    guestRooms.get(i).getGuests().setName(userChoice);
                }
                //This else if-method changes the guests favorite activity if the user input is == 2
                else if (userinput == 2) {

                    System.out.println("What would you like to change favorite activity to?");
                    System.out.print("> ");
                    String userChoice = getUserString();

                    guestRooms.get(i).getGuests().setFavoriteActivity(userChoice);
                }
                //This else if-method changes the guests favorite food if the user input == 3
                else if (userinput == 3) {

                    System.out.println("What would you like to change favorite food to?");
                    System.out.print("> ");
                    String userChoice = getUserString();

                    guestRooms.get(i).getGuests().setFavoriteFood(userChoice);
                }
            }
        }
    }

    public void individualBookingDetails() {

        listBookings();

        System.out.println("Who's booking details would you like to show.");
        System.out.println("> ");
        String userChoice = getUserString();

        for (int i = 0; i < guests.size(); i++) {

            if (userChoice.equals(guestRooms.get(i).getGuests().getName())) {

                System.out.println("Name                   Favorite Activity                   Favorite Food");
                System.out.println("-----------------------------------------------------------------------");
                System.out.printf("%-23s%-36s%s\n\n", guestRooms.get(i).getGuests().getName(), guestRooms.get(i).getGuests().getFavoriteActivity(), guestRooms.get(i).getGuests().getFavoriteFood());


                System.out.println("Room Number            Description");
                System.out.println("----------------------------------");
                System.out.printf("%-23d%s\n", guestRooms.get(i).getRoomNumber(), guestRooms.get(i).describe());
            }
        }
    }

    public void filterBookings() {

        //searching the room numbers by the name

       /* String search=getUserString().toLowerCase();

        for (int i = 0; i < guestRooms.size(); i++) {

            if (guestRooms.get(i).getGuests().getName().equals(search)) {

                System.out.println(" Room number of "+ search+ ":"+guestRooms.get(i).getRoomNumber());
            }
        }
    }*/

        if (guests.size() != 0) {

            System.out.println("Enter what you would like to filter the names by");
            System.out.print("> ");
            String userChoice = getUserString().toLowerCase();
            System.out.println("These are all guests that has [" + userChoice + "] in their name");
            System.out.println("----------------------------------------------------------------");

            for (int i = 0; i < guestRooms.size(); i++) {

                if ((guestRooms.get(i).getGuests().getName()).contains(userChoice)) {

                    System.out.printf("%-19s%d\n", guestRooms.get(i).getGuests().getName(), guestRooms.get(i).getRoomNumber());
                }
            }
        } else {
            System.out.println("There are no guests booked at this point of time " );
        }
    }

    public static String getUserString() {

        Scanner myScanner = new Scanner(System.in);

        return myScanner.nextLine();
    }

    public static int getUserInt() {

        Scanner myScanner = new Scanner(System.in);

        int userChoice;

        while (true) {

            try {
                userChoice = Integer.parseInt(myScanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Faulty input");
                System.out.println("> ");
            }
        }
        return userChoice;
    }
}

