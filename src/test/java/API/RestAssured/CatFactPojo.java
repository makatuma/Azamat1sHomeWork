package API.RestAssured;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter

public class CatFactPojo {

    private String _id;
    private String type;
    private String text;
    private Map<String, Object> user;
    private int upvotes;
    private String userUpvoted;



}
