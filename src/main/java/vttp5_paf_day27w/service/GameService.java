package vttp5_paf_day27w.service;

import java.lang.classfile.ClassFile.Option;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5_paf_day27w.model.Review;
import vttp5_paf_day27w.repo.GameRepo;

@Service
public class GameService {

    @Autowired
    private GameRepo gameRepo; 

    public List<Review> getAllReviews() {

        return gameRepo.getAllReviews();

    }

    // TASK A
    public String insertReview(Map<String, String> data) {

        Review r = mapToReviewPojo(data);

        if (checkReview(r) != null) {
            return checkReview(r);

        }

        return gameRepo.insertReview(r);

    }

    // helper method 
    // Map<String, String> --> Review POJO 
    private Review mapToReviewPojo(Map<String, String> data) {

        Review r = new Review(); 
        r.setUser(data.get("user"));
        r.setRating(Integer.valueOf(data.get("rating")));
        r.setComment(data.get("comment"));

        int gameId = Integer.valueOf(data.get("ID"));
        r.setID(gameId);

        r.setPosted(new java.util.Date());

        r.setName(getGameNameById(gameId));

        return r;

    }

    // helper method 
    // String --> Date 
    private Date stringToDate(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date dateNew = new Date();

        try {
            dateNew = sdf.parse(dateString);

        } catch (ParseException e) {
            System.out.println(e.getMessage());

        }

        return dateNew;

    }
    
    // helper method 
    // check if conditions are met for valid Review insert
    public String checkReview(Review review) {

        // user --> not null 
        String user = review.getUser();
        if (user.isEmpty() || user.isBlank()) {
            return "User name field cannot be empty";

        }

        // rating --> not null & between 0 and 10 
        else if (Integer.valueOf(review.getRating()) == null) {
            return "Rating field cannot be empty";

        }

        else if (Integer.valueOf(review.getRating()) > 10 || Integer.valueOf(review.getRating()) < 0) {
            return "Rating must be between 0 and 10";

        }

        // game id --> must be valid game id from games collection
        else if (checkGameIdExists(review.getID()) == null) {
            return "Game ID doesn't exist";

        }

        return null;

    }

    // helper method 
    // check if valid game id from game collection 
    // set game name based on id 
    public Document checkGameIdExists(int gameId) {

        Optional<Document> document = gameRepo.checkGameIdExists(gameId);

        if (document.isEmpty()) {
            return null;

        } else {
            return document.get();

        }

    }

    // helper method 
    public String getGameNameById(int gameId) {

        Document document = checkGameIdExists(gameId);
        String gameName = document.getString("name");
        return gameName;

    }

}
