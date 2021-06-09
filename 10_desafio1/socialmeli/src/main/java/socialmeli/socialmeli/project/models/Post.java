package socialmeli.socialmeli.project.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
    public class Post implements Comparable<Post>{
        private Integer userId;
        private Integer idPost;
        private Date date;
        private Product detail;
        private Integer category;
        private Double price;

    @Override
    public int compareTo(Post o) {
        return getDate().compareTo(o.getDate());
        }
    }
