package services;

import models.FootballClub;
import models.Match;
import models.SportsClub;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PremierLeagueManager implements LeagueManager{

    private static final List<SportsClub> clubsList = new ArrayList<>();
    private static final List<Match> playedMatchesList = new ArrayList<>();
    private final String dataFile = "public/dataFile.txt";
    private final Scanner NEW_SCANNER = new Scanner(System.in);
    private static final Random newRandom = new Random();

    @Override
    public void addClub(SportsClub sportsClub) {
        if(!clubsList.contains(sportsClub)){
            clubsList.add(sportsClub);
            System.out.println("\n\t"+sportsClub.getSportClubName() + " Successfully added.");
        }else{
            System.out.println("Club is already added.\n");
        }
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int clubsListSize(){
        return clubsList.size();
    }

    @Override
    public void deleteClubByName(String clubName) {
        for (SportsClub club: clubsList){
            if (club.getSportClubName().equals(clubName)){
                clubsList.remove(club);
                System.out.println(clubName + " Successfully Deleted.");
                return;
            }
        }
        System.out.println("Club " + clubName + " does not exist.\n");
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClubByID(String clubID) {
        for (SportsClub club: clubsList){
            if (club.getClubID().equals(clubID)){
                clubsList.remove(club);
                System.out.println(clubID + " Successfully Deleted.");
                return;
            }
        }
        System.out.println("Club " + clubID + " does not exist.\n");
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayStatisticsByClubID(String clubID) {

        for (SportsClub club : clubsList){
            if (club.getClubID().equals(clubID)){
                displayStatistics(club);
                return;
            }
        }
        System.out.println("Club ID " + clubID + " does not exist.\n");
    }

    @Override
    public void displayStatisticsByClubName(String clubName) {

        for (SportsClub club : clubsList){
            if (club.getSportClubName().equals(clubName)){
                displayStatistics(club);
                return;
            }
        }
        System.out.println("Club Name " + clubName + " does not exist.\n");
    }

    @Override
    public void displayStatistics(SportsClub club) {
        System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");
        System.out.format("\t| Position |   Club Name   |  Played  |  Won  |  Drawn  |  Defeats  |   GF   |   GA   | Difference | Points |%n");
        System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");
        ((FootballClub) club).setDifference(((FootballClub) club).getNoScoredGoals()-((FootballClub) club).getGoalAgainst());
        String data = "\t|    %-5s | %-13s | %-8d | %-5d | %-7d | %-9d | %-6d | %-6d | %-10d | %-6d |%n";
        System.out.format(data, club.getClubPosition(), club.getSportClubName(), ((FootballClub) club).getNoPlayedMatches(), ((FootballClub) club).getNoWins(), ((FootballClub) club).getNoDraws(), ((FootballClub) club).getNoDefeats(), ((FootballClub) club).getNoScoredGoals(), ((FootballClub) club).getGoalAgainst(), ((FootballClub) club).getDifference(), ((FootballClub) club).getCurrentPoints());
        System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");
    }

    @Override
    public void sortClubListByPoints() {
        Collections.sort(clubsList, new ClubComparatorByPoints());
        for (SportsClub club : clubsList){
            club.setClubPosition(clubsList.indexOf(club) + 1);
        }
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortClubListByGoals() {
        Collections.sort(clubsList, new ClubComparatorByGoals());
        for (SportsClub club : clubsList){
            club.setClubPosition(clubsList.indexOf(club) + 1);
        }
        try {
            saveData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayPremierLeagueTable(int option) {

        if (option == 1){
            sortClubListByPoints();
        }else if (option == 0){
            sortClubListByGoals();
        }

        if (!clubsList.isEmpty()){

            System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");
            System.out.format("\t| Position |   Club Name   |  Played  |  Won  |  Drawn  |  Defeats  |   GF   |   GA   | Difference | Points |%n");
            System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");

            for (SportsClub club : clubsList){
                ((FootballClub) club).setDifference(((FootballClub) club).getNoScoredGoals()-((FootballClub) club).getGoalAgainst());
                String data = "\t|    %-5s | %-13s | %-8d | %-5d | %-7d | %-9d | %-6d | %-6d | %-10d | %-6d |%n";
                System.out.format(data, club.getClubPosition(), club.getSportClubName(), ((FootballClub) club).getNoPlayedMatches(), ((FootballClub) club).getNoWins(), ((FootballClub) club).getNoDraws(), ((FootballClub) club).getNoDefeats(), ((FootballClub) club).getNoScoredGoals(), ((FootballClub) club).getGoalAgainst(), ((FootballClub) club).getDifference(), ((FootballClub) club).getCurrentPoints());
            }
            System.out.format("\t+----------+---------------+----------+-------+---------+-----------+--------+--------+------------+--------+%n");

        }
        else {
            System.out.println("Club list is empty.");
        }

    }

    public int[] analyzeMatchPoints(Match match){
        int[] matchScoreData = new int[2];

        if (match.getFirstClubsScoredGoals() == match.getSecondClubsScoredGoals()){
            matchScoreData[0] = 1;
            matchScoreData[1] = 1;
        }
        else if (match.getFirstClubsScoredGoals() > match.getSecondClubsScoredGoals()){
            matchScoreData[0] = 3;
        }
        else{
            matchScoreData[1] = 3;
        }
        return matchScoreData;
    }

    @Override
    public void displayMatchStatisticTable() {
        Collections.sort(playedMatchesList, new MatchComparatorByDate());
        if(!playedMatchesList.isEmpty()){

            System.out.println("\n\t\t\t\t\t\t\t\t------| Played Matches  |------");

            System.out.format("\t+------------+----------+---------------+----------+-------+-------------+---------+%n");
            System.out.format("\t|    Date    | Position |   Club Name   |    GF    |   GA  |  Difference |  Points |%n");
            System.out.format("\t+------------+----------+---------------+----------+-------+-------------+---------+%n");

            for (Match match: playedMatchesList){

                int[] matchScoreData = analyzeMatchPoints(match);

                SportsClub club  = match.getFirstClub();
                SportsClub club1 = match.getSecondClub();

                ((FootballClub) club).setDifference(match.getFirstClubsScoredGoals() - match.getSecondClubsScoredGoals());

                String data = "\t| %-10s |    %-5s | %-13s |   %-6d |%-6d |  %-10d |  %-6d |%n";
                System.out.format(data,match.getPlayedDate(), club.getClubPosition(), club.getSportClubName(), match.getFirstClubsScoredGoals(), match.getSecondClubsScoredGoals(), ((FootballClub) club).getDifference(), matchScoreData[0]);
                System.out.format("\t|            +----------+---------------+----------+-------+-------------+---------+%n");

                ((FootballClub) club1).setDifference(match.getSecondClubsScoredGoals() - match.getFirstClubsScoredGoals());

                System.out.format(data, "", club1.getClubPosition(), club1.getSportClubName(),match.getSecondClubsScoredGoals(),match.getFirstClubsScoredGoals(), ((FootballClub) club1).getDifference(), matchScoreData[1]);
                System.out.format("\t+------------+----------+---------------+----------+-------+-------------+---------+%n");

            }
        }
    }

    public void printMatchStatisticTable(Match match){

        int[] matchData = analyzeMatchPoints(match);

        SportsClub club  = match.getFirstClub();
        SportsClub club1 = match.getSecondClub();

        System.out.println("\n\t\t\t\t\t\t------| Date : " + match.getPlayedDate() + " |------");

        System.out.format("\t+----------+---------------+----------+-------+-------------+---------+%n");
        System.out.format("\t| Position |   Club Name   |    GF    |   GA  |  Difference |  Points |%n");
        System.out.format("\t+----------+---------------+----------+-------+-------------+---------+%n");

        ((FootballClub) club).setDifference(match.getFirstClubsScoredGoals() - match.getSecondClubsScoredGoals());

        String data = "\t|    %-5s | %-13s |   %-6d |%-6d |  %-10d |  %-6d |%n";
        System.out.format(data, club.getClubPosition(), club.getSportClubName(), match.getFirstClubsScoredGoals(), match.getSecondClubsScoredGoals(), ((FootballClub) club).getDifference(), matchData[0]);

        ((FootballClub) club1).setDifference(match.getSecondClubsScoredGoals() - match.getFirstClubsScoredGoals());

        System.out.format(data, club1.getClubPosition(), club1.getSportClubName(), match.getSecondClubsScoredGoals(), match.getFirstClubsScoredGoals(), ((FootballClub) club1).getDifference(), matchData[1]);
        System.out.format("\t+----------+---------------+----------+-------+-------------+---------+%n");

    }

    private void analyzeMatch(FootballClub firstClub, int firstClubsScoredGoals, FootballClub secondClub, int secondClubsScoredGoals){

        firstClub.setNoPlayedMatches(1 + firstClub.getNoPlayedMatches());
        secondClub.setNoPlayedMatches(1 + secondClub.getNoPlayedMatches());

        if (firstClubsScoredGoals > secondClubsScoredGoals){
            firstClub.setNoWins (1+ firstClub.getNoWins());
            secondClub.setNoDefeats(1 + secondClub.getNoDefeats());
            firstClub.setCurrentPoints(3 + firstClub.getCurrentPoints());

        }else if(firstClubsScoredGoals == secondClubsScoredGoals) {
            firstClub.setCurrentPoints(1 + firstClub.getCurrentPoints());
            secondClub.setCurrentPoints(1 + secondClub.getCurrentPoints());
            firstClub.setNoDraws(1 + firstClub.getNoDraws());
            secondClub.setNoDraws(1 + secondClub.getNoDraws());
        }else{
            firstClub.setNoDefeats(1 + firstClub.getNoDefeats());
            secondClub.setNoWins(1 + secondClub.getNoWins());
            secondClub.setCurrentPoints(3 + secondClub.getCurrentPoints());
        }
        //Scored Goals.
        firstClub.setNoScoredGoals(firstClub.getNoScoredGoals() + firstClubsScoredGoals);
        secondClub.setNoScoredGoals(secondClub.getNoScoredGoals() + secondClubsScoredGoals);

        // Goal Against.
        secondClub.setGoalAgainst(secondClub.getGoalAgainst() + firstClubsScoredGoals);
        firstClub.setGoalAgainst(firstClub.getGoalAgainst() + secondClubsScoredGoals);

    }

    @Override
    public void displayStatisticsByDate(LocalDate date) {
        for (Match match : playedMatchesList){
            if (match.getPlayedDate().equals(date)){
                printMatchStatisticTable(match);
                break;
            }
        }
    }

    @Override
    public void addPlayedMatch(Match match){
        if(!playedMatchesList.contains(match)){
            playedMatchesList.add(match);
            analyzeMatch((FootballClub) match.getFirstClub(), match.getFirstClubsScoredGoals(), (FootballClub) match.getSecondClub(), match.getSecondClubsScoredGoals());
            System.out.println(match.getFirstClub().getSportClubName()+" Vs "+match.getSecondClub().getSportClubName()+" Match Details are Successfully Added. Date = "+ match.getPlayedDate());
            printMatchStatisticTable(match);

        }else{
            System.out.println("Match Details are already added.");
        }
    }

    @Override
    public void addRandomMatch() {
        loadData();
        if (clubsList.isEmpty()){
            System.out.println("Club Database is Empty.");
            return;
        }
        if(clubsList.size() == 1){
            System.out.println("There are only one club in the database, need at least two clubs to play a match");
            return;
        }
        else{
            int index = newRandom.nextInt(clubsList.size());
            SportsClub club1 = clubsList.get(index);
            int club1ScoredGoals = (int) (Math.random()*32);
            SportsClub club2;

            while (true){
                int index2 = newRandom.nextInt(clubsList.size());
                if (!club1.equals(clubsList.get(index2))) {
                    club2 = clubsList.get(index2);
                    int club2ScoredGoals = (int) (Math.random()*4);
                    System.out.println(club1.getSportClubName() + " Vs "+ club2.getSportClubName());
                    System.out.println(club1ScoredGoals + " Vs "+ club2ScoredGoals);
                    addPlayedMatch(new Match(club1, club1ScoredGoals, club2, club2ScoredGoals, generateRandomDate()));
                    break;
                }
            }
            try {
                saveData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public LocalDate generateRandomDate(){
        while (true){
            LocalDate randomDate = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextInt(-36500, 36500));
            if (LocalDateTime.now().getYear() >= randomDate.getYear() && 2000 <= randomDate.getYear() ){
                return randomDate;
            }
        }
    }

    @Override
    public SportsClub clubNameValidator(){
        while (true){
            System.out.print("Enter Club Name : ");
            String clubName = NEW_SCANNER.next();

            for (SportsClub club: clubsList){
                if (club.getSportClubName().equals(clubName)){
                    return (FootballClub) club;
                }
            }
            System.out.println("Entered Club Does Not Exist.\n");
        }
    }


    @Override
    public SportsClub clubNameValidator(SportsClub club){
        while (true){
            System.out.print("Enter Club Name : ");
            String clubName = NEW_SCANNER.next();

            for (SportsClub selectedClub: clubsList){
                if (selectedClub.getSportClubName().equals(clubName)){
                    if (!selectedClub.getSportClubName().equals(club.getSportClubName())){
                        return (FootballClub) selectedClub;
                    }else{
                        System.out.println("Entered Sport Club Already Added as a First Team.");
                    }
                }
            }
            System.out.println("Entered Club Does Not Exist.\n");
        }
    };


    @Override
    public void loadData() {
        try{
            FileInputStream inputFile = new FileInputStream(dataFile);
            ObjectInputStream dataInput = new ObjectInputStream(inputFile);

            clubsList.clear();
            for (SportsClub selectedClub : (List<SportsClub>) dataInput.readObject()){
                clubsList.add(selectedClub);
            }

            playedMatchesList.clear();
            for (Match selectedMatch : (List<Match>) dataInput.readObject()){
                playedMatchesList.add(selectedMatch);
            }

            inputFile.close();
            dataInput.close();

        }catch (IOException | ClassNotFoundException e){
            System.out.format("\n\t\t+-----------+---------------+-----------+---------+%n");
            System.out.println("\t\t|         The Data file doesn't exist.            |");
            System.out.format("\t\t+-----------+---------------+-----------+---------+%n");
        }
    }

    @Override
    public void saveData() throws IOException {

        FileOutputStream outputFile = new FileOutputStream(dataFile);
        ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

        outputObject.writeObject(clubsList);
        outputObject.writeObject(playedMatchesList);

        outputFile.flush();
        outputFile.close();
        outputObject.close();

        System.out.format("\n\t\t+---------+--------------+-----------+--------+%n");
        System.out.println("\t\t|     The Club data is successfully saved.    |");
        System.out.format("\t\t+---------+---------------+----------+--------+%n");
    }

}
