package services;

import models.FootballClub;
import models.Match;
import models.SportsClub;
import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.util.Scanner;

public class Console {

    private final static LeagueManager manager = new PremierLeagueManager();
    private final static Scanner NEW_SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("\n\t\t\t\tWelcome to Sport Club Management System.");
        System.out.format("\t\t\t+---------------------------------------------+%n");
        System.out.format("\t\t\t\t+------------------------------------+%n");
        manager.loadData();

        consoleLoop:
        while (true) {
            display();

            int userInput = integerInputsValidator();

            switch (userInput){
                case 1:
                    addClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    premierLeagueTable();
                    break;
                case 5:
                    playedMatches();
                    break;
                case 6:
                    addMatch();
                    manager.saveData();
                    break;
                case 7:
                    playRandomMatch();
                    manager.saveData();
                    break;
                case 8:
                    manager.loadData();
                    break;
                case 9:
                    manager.saveData();
                    break;
                case 10:
                    manager.saveData();
                    break consoleLoop;
                default:
                    System.out.println("Your Choice is Invalid");
            }
        }
    }

    private static void display(){
        System.out.println("\n\tMain Menu\n");
        System.out.println("1. Add a Club.");
        System.out.println("2. Delete a Club.");
        System.out.println("3. Display Statistics.");
        System.out.println("4. Display Premier League Table.");
        System.out.println("5. Display Statistics of the Played Matches.");
        System.out.println("6. Add a Played Match.");
        System.out.println("7. Add a Random Match.");
        System.out.println("8. Manually Load data.");
        System.out.println("9. Manually Save data.");
        System.out.println("10. Quit the application.");
        System.out.print("\nEnter Your Choice : ");
    }

    // Add Club Section.
    private static void addClub() {

        String clubName = getClubName("Enter Club Name : ");

        System.out.print("Enter Club Location : ");
        String clubLocation = NEW_SCANNER.next();

        System.out.println("\n\t\tYour Club ID Is : SportClubID" + manager.clubsListSize());
        String clubID = "SportClubID" + manager.clubsListSize();

        SportsClub club = new FootballClub(clubID, clubName, clubLocation);
        manager.addClub(club);
    }

    // Delete Club Section.
    private static void deleteClub() {
        deleteClubLoop:
        while (true){
            System.out.println("\n\tDelete Club\n");

            switch (getClubSelectorOption()){
                case 1:
                    System.out.print("Enter Club ID : ");
                    String clubID = NEW_SCANNER.next();
                    manager.deleteClubByID(clubID);
                    break;
                case 2:
                    manager.deleteClubByName(getClubName("Enter Club Name : "));
                    break;
                case 3:
                    break deleteClubLoop;
                default:
                    System.out.println("Your Choice is Invalid");
            }
        }
    }


    // Display Statistics Section.
    private static void displayStatistics() {
        System.out.println("\n\tDisplay Statistics\n");

        displayStatisticsLoop:
        while (true) {
            System.out.println("\n\tDisplay Statistics\n");

            switch (getClubSelectorOption()){
                case 1:
                    System.out.print("Enter Club ID : ");
                    String clubID = NEW_SCANNER.next();
                    manager.displayStatisticsByClubID(clubID);
                    break;
                case 2:
                    manager.displayStatisticsByClubName(getClubName("Enter Club Name : "));
                    break;
                case 3:
                    break displayStatisticsLoop;
                default:
                    System.out.println("Your Choice is Invalid");
            }
        }
    }

    // Display Premier  League Table Section.
    private static void premierLeagueTable() throws IOException {
        System.out.println("\n\tDisplay Premier League Table\n");

        premierLeagueTableLoop:
        while (true) {
            switch (getUserOptionCLIOrGUI()){
                case 1:
                    displayPremierLeagueTableCLI();
                    break;
                case 2:
                    manager.sortClubListByPoints();
                    manager.saveData();
                    java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:4200/home"));
                    break ;
                case 3:
                    break premierLeagueTableLoop;
                default:
                    System.out.println("Your Choice is Invalid.");
            }
        }
    }

    // Display Played Matches.
    private static void playedMatches() throws IOException {
        System.out.println("\n\tDisplay Played Matches\n");

        playedMatchesLoop:
        while (true) {
            switch (getUserOptionCLIOrGUI()){
                case 1:
                    displayMatchStatistics();
                    break;
                case 2:
                    // GUI Of this option and the GUI of the Random Match is the same.
                    java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:4200/randommatch"));
                    break;
                case 3:
                    break playedMatchesLoop;
                default:
                    System.out.println("Your Choice is Invalid.");
            }
        }
    }

    // Display Random Match Section.
    private static void playRandomMatch() throws IOException {
        System.out.println("\n\tPlayed Random Match\n");
        playRandomMatchLoop:
        while (true) {
            switch (getUserOptionCLIOrGUI()){
                case 1:
                    manager.addRandomMatch();;
                    break;
                case 2:
                    manager.sortClubListByPoints();
                    manager.saveData();
                    // GUI Of this option and the GUI of the Played Match Table is the same.
                    java.awt.Desktop.getDesktop().browse(URI.create("http://localhost:4200/randommatch"));
                    break ;
                case 3:
                    break playRandomMatchLoop;
                default:
                    System.out.println("Your Choice is Invalid.");
            }
        }
    }

    private static int getClubSelectorOption(){
        System.out.println("Select Club Using,");
        System.out.println("\t1.SportsClubID.");
        System.out.println("\t2.SportsClub Name.");
        System.out.println("\t3.Go Back to Main Menu.");
        System.out.print("Enter Your Option : ");

        return integerInputsValidator();
    }

    private static int getUserOptionCLIOrGUI(){
        System.out.println("CLI or GUI,");
        System.out.println("\t1.CLI.");
        System.out.println("\t2.GUI.");
        System.out.println("\t3.Go Back To Main Menu.");
        System.out.print("Enter Your Option : ");

        return integerInputsValidator();
    }


    private static void displayPremierLeagueTableCLI(){
        displayPremierLeagueTableCLILoop:
        while (true) {
            System.out.println("Select Sorting Method.");
            System.out.println("\t1.Sort By Scored Goals.");
            System.out.println("\t2.Sort By Points.");
            System.out.println("\t3.Go Back.");
            System.out.print("Enter Your Option : ");

            int userInput = NEW_SCANNER.nextInt();

            switch (userInput){
                case 1:
                    manager.displayPremierLeagueTable(0);
                    break;
                case 2:
                    manager.displayPremierLeagueTable(1);
                    break ;
                case 3:
                    break displayPremierLeagueTableCLILoop;
                default:
                    System.out.println("Your Choice is Invalid.");
            }
        }
    }

    private static void displayMatchStatistics(){
        try {
            manager.loadData();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        displayMatchStatisticsLoop:
        while (true) {
            System.out.println("\n\tDisplay Statistics of the Played Matches\n");

            System.out.println("Find Match Using,");
            System.out.println("\t1.Date.");
            System.out.println("\t2.Display Statistics for All the Matches.");
            System.out.println("\t3.Go Back to Main Menu.");
            System.out.print("Enter Your Option : ");

            int userInput = NEW_SCANNER.nextInt();

            switch (userInput){
                case 1:
                    manager.displayStatisticsByDate(getDateFromUser());
                    break;
                case 2:
                    manager.displayMatchStatisticTable();
                case 3:
                    break displayMatchStatisticsLoop;
                default:
                    System.out.println("Your Choice is Invalid");
            }
        }
    }

    // Add Match Section.
    private static void addMatch() {
        System.out.println("\n\tAdd Match\n");

        Match newMatch = new Match();
        newMatch.setPlayedDate(getDateFromUser());

        System.out.println("\n\tEnter First Team's Information.\t\t");
        newMatch.setFirstClub(manager.clubNameValidator());
        newMatch.setFirstClubsScoredGoals(getScoredGoals());

        System.out.println("\n\tEnter Second Team's Information.\t\t");
        newMatch.setSecondClub(manager.clubNameValidator(newMatch.getFirstClub()));
        newMatch.setSecondClubsScoredGoals(getScoredGoals());

        System.out.println("First Clubs Name : "+newMatch.getFirstClub().getSportClubName()+ " Points : "+newMatch.getFirstClubsScoredGoals());
        System.out.println("Second Clubs Name : "+newMatch.getSecondClub().getSportClubName()+ " Points : "+newMatch.getSecondClubsScoredGoals());

        manager.addPlayedMatch(newMatch);
    }

    // Date Validator - This method is specifically designed to receive valid Date Information from user.
    private static LocalDate getDateFromUser(){
        System.out.println("Enter Match Date:");
        int day = dateValidator("\t\tDay : ", 31);
        int month = dateValidator("\t\tMonth : ", 12);
        int year = yearValidator();
        return LocalDate.of(year,month,day);
    }

    // Integer Inputs Validator
    private static int integerInputsValidator(){
        do{
            if (NEW_SCANNER.hasNextInt()){
                return NEW_SCANNER.nextInt();
            }
            else{
                System.out.print("\tPlease Enter Integer Value for this, \n\t" + "\tEnter Number as a Input : ");
                NEW_SCANNER.next();
            }
        }while (true);
    }

    // Scored Goals Validator - This method is specifically designed to receive valid data of scored goals.
    private static int getScoredGoals(){
        System.out.print("\tEnter Number of Scored Goals : ");
        do{
            if (NEW_SCANNER.hasNextInt()){
                return NEW_SCANNER.nextInt();
            }
            else{
                System.out.print("\tPlease Enter Integer Value for this, \n\t" + "\tEnter Number of Scored Goals : ");
                NEW_SCANNER.next();
            }
        }while (true);
    }

    // Date Validation.
    private static int dateValidator(String question, int maxValue){
        while (true){
            System.out.print(question);
            int value = integerInputsValidator();
            if (value <= maxValue && 1 <= value) {
                return value;
            } else {
                System.out.println("Invalid Input");
            }
        }
    }

    // Year Validation.
    private static int yearValidator(){
        while (true){
            System.out.print("\t\tYear : ");
            int value = integerInputsValidator();
            if (((int) (Math.log10(value) + 1 ) == 4)) {
                return value;
            } else {
                System.out.println("Invalid Year");
            }
        }
    }

    // Get Club Name From User
    private static String getClubName(String question){
        System.out.print(question);
        NEW_SCANNER.nextLine();
        return NEW_SCANNER.nextLine();
    }
}
