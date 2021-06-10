package JavaUtils;

import com.example.desafio1.model.User;
import com.example.desafio1.service.dto.post.ResponsePostDTO;
import com.example.desafio1.service.dto.post.ResponsePromoPostDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class JavaUtils {

    // Convert Date to LocalDate
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(dateToConvert.toInstant(), ZoneId.systemDefault());
    }

    // Order Post by Date ASC
    public static void orderByDateAsc(ArrayList<ResponsePostDTO> posts) {
        Comparator<ResponsePostDTO> c = (p1, p2) -> p1.getDate().compareTo(p2.getDate());
        posts.sort(c);
    }

    // Order Post by Date DESC
    public static void orderByDateDesc(ArrayList<ResponsePostDTO> posts) {
        Comparator<ResponsePostDTO> c = (p1, p2) -> p2.getDate().compareTo(p1.getDate());
        posts.sort(c);
    }

    // Order Users by Name ASC
    public static void orderByUserNameAsc(ArrayList<User> users) {
        Comparator<User> c = (usr1, usr2) -> usr1.getUserName().compareTo(usr2.getUserName());
        users.sort(c);
    }

    // Order Users by Name DESC
    public static void orderByUserNameDesc(ArrayList<User> users) {
        Comparator<User> c = (usr1, usr2) -> usr2.getUserName().compareTo(usr1.getUserName());
        users.sort(c);
    }

    // Order Posts by Name ASC
    public static void orderByPostNameAsc(ArrayList<ResponsePromoPostDTO> posts) {
        Comparator<ResponsePromoPostDTO> c = (post1, post2) -> post1.getDetail().getProductName().compareTo(post2.getDetail().getProductName());
        posts.sort(c);
    }

    // Order Posts by Name DESC
    public static void orderByPostNameDesc(ArrayList<ResponsePromoPostDTO> posts) {
        Comparator<ResponsePromoPostDTO> c = (post1, post2) -> post2.getDetail().getProductName().compareTo(post1.getDetail().getProductName());
        posts.sort(c);
    }
}
