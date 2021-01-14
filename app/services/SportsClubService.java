package services;

import models.Match;
import models.SportsClub;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SportsClubService {
    private static SportsClubService instance;
    private static final List<SportsClub> clubsList = new ArrayList<>();
    private static final List<Match> playedMatchesList = new ArrayList<>();
    private static final LeagueManager manager = new PremierLeagueManager();
    private static Match newMatch;

    public static SportsClubService getInstance() {
        if (instance == null) {
            instance = new SportsClubService();
        }
        return instance;
    }

    public List<SportsClub> getAllFootballClubs(int option) {
        loadData();
        if (option == 0 ){
            Collections.sort(clubsList, new ClubComparatorByPoints());
        }else{
            Collections.sort(clubsList, new ClubComparatorByGoals());
        }

        return clubsList;
    }

    public List<Match> getAllPlayedMatches() {
        loadData();
        Collections.sort(playedMatchesList, new MatchComparatorByDate());
        return playedMatchesList;
    }

    public void loadData(){
        try{
            FileInputStream inputFile = new FileInputStream("public/dataFile.txt");
            ObjectInputStream dataInput = new ObjectInputStream(inputFile);

            clubsList.clear();
            for (SportsClub selectedClub : (List<SportsClub>) dataInput.readObject()){
                if (!clubsList.contains(selectedClub)){
                    clubsList.add(selectedClub);
                }
            }

            Collections.sort(clubsList, new ClubComparatorByPoints());

            playedMatchesList.clear();
            for (Match selectedMatch : (List<Match>) dataInput.readObject()){
                if (!playedMatchesList.contains(selectedMatch)){
                    playedMatchesList.add(selectedMatch);
                }
            }

            if (!playedMatchesList.isEmpty()){
                newMatch = playedMatchesList.get(playedMatchesList.size() - 1);
            }

            inputFile.close();
            dataInput.close();

        }catch (IOException | ClassNotFoundException e){
            System.out.println("The Data file doesn't exist.");
        }
    }

    public void saveData() throws IOException {

        FileOutputStream outputFile = new FileOutputStream("public/dataFile.txt");
        ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);

        outputObject.writeObject(clubsList);
        outputObject.writeObject(playedMatchesList);

        outputFile.flush();
        outputFile.close();
        outputObject.close();

        System.out.println("The Club data is successfully saved.");
    }

    public List<Match> filterMatchList(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date, formatter);
        List<Match> tempList = new ArrayList<>();

        for (Match match : playedMatchesList){

            if (match.getPlayedDate().equals(localDate)){
                tempList.add(match);
                System.out.println(match.getPlayedDate() + "=" + localDate);
            }
        }
        return tempList;
    }

    public Match createRandomMatch() {
        manager.addRandomMatch();
        loadData();
        return newMatch;

    }

}
