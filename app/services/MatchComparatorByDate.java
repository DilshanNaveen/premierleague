package services;

import models.Match;
import java.util.Comparator;

public class MatchComparatorByDate implements Comparator<Match> {

    @Override
    public int compare(Match match1, Match match2) {
        return match1.getPlayedDate().compareTo(match2.getPlayedDate());
    }
}
