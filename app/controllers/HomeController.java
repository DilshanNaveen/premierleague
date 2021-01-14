package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import play.mvc.*;
import services.SportsClubService;
import utils.AppUtil;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    public Result getAllClubs(int option){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(SportsClubService.getInstance().getAllFootballClubs(option), JsonNode.class);
        return ok(AppUtil.createResponse(jsonData, true));
    }

    public Result getAllPlayedMatches(){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(SportsClubService.getInstance().getAllPlayedMatches(), JsonNode.class);
        return ok(AppUtil.createResponse(jsonData, true));
    }

    public Result getRandomMatch(){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(SportsClubService.getInstance().createRandomMatch(), JsonNode.class);
        return ok(AppUtil.createResponse(jsonData, true));
    }
    public Result getFilteredMatches(String date){
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(SportsClubService.getInstance().filterMatchList(date), JsonNode.class);
        return ok(AppUtil.createResponse(jsonData, true));
    }
}