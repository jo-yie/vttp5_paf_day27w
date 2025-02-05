package vttp5_paf_day27w.repo;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp5_paf_day27w.model.Review;
import vttp5_paf_day27w.utils.Constants;

@Repository
public class GameRepo {

    @Autowired
    private MongoTemplate template; 

    /*
    db.reviews.find({})
    */
    public List<Review> getAllReviews() {
        
        Query query = new Query();
        return template.find(query, Review.class, Constants.C_REVIEWS);

    }

    // TASK A
    /*
        db.reviews.insert(
            {
                user: "jo yie",
                rating: 5,
                comment: "comment",
                ID: "game id",
                posted: "2025-02-20",
                name: "board game"
            }
        )
    */
    public String insertReview(Review review) {

        Document toInsert = new Document(); 
        toInsert.put("user", review.getUser());
        toInsert.put("rating", review.getRating());
        toInsert.put("comment", review.getComment());
        toInsert.put("ID", review.getID());
        toInsert.put("posted", review.getPosted());
        toInsert.put("name", review.getName());

        Document newDoc = template.insert(toInsert, Constants.C_REVIEWS);
        ObjectId id = newDoc.getObjectId("_id");

        return id.toString();

    }

    
}
