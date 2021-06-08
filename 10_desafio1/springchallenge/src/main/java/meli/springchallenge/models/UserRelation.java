package meli.springchallenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRelation {

    private int relationId;
    private int follower;
    private int following;
    private Date since;
}
