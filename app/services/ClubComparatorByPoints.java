package services;

import models.FootballClub;
import models.SportsClub;
import java.util.Comparator;

public class ClubComparatorByPoints implements Comparator<SportsClub> {

    @Override
    public int compare(SportsClub club1, SportsClub club2) {

        if (((FootballClub) club1).getCurrentPoints() == ((FootballClub) club2).getCurrentPoints() ){
            return 0;
        }
        if (((FootballClub) club1).getCurrentPoints() < ((FootballClub) club2).getCurrentPoints()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
