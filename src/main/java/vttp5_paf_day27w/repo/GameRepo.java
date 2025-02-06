package vttp5_paf_day27w.repo;

import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
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

        Document toInsert = reviewPojoToDocument(review);

        Document newDoc = template.insert(toInsert, Constants.C_REVIEWS);
        ObjectId id = newDoc.getObjectId(Constants.F_REVIEW_ID);

        // returns _id field
        return id.toString();

    }

    // helper method 
    // Review POJO --> Document
    private Document reviewPojoToDocument(Review review) {

        Document toInsert = new Document(); 
        toInsert.put("user", review.getUser());
        toInsert.put("rating", review.getRating());
        toInsert.put("comment", review.getComment());
        toInsert.put("ID", review.getID());
        toInsert.put("posted", review.getPosted());
        toInsert.put("name", review.getName());
    
        return toInsert; 

    }

    // helper method
    // check if game id exists 
    /*
    db.game.find({
        gid : 1
    })
    */
    public Optional<Document> checkGameIdExists(int gameId) {

        Criteria criteria = Criteria.where(Constants.F_GAME_ID).is(gameId);
        Query query = new Query().addCriteria(criteria);

        Document document = template.findOne(query, Document.class, Constants.C_GAMES);

        return Optional.ofNullable(document);

    }
    
}
