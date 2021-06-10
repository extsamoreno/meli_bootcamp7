package desafio1.demo.Helper;

import desafio1.demo.Model.Entity.Post;
import desafio1.demo.Model.Entity.User;

import java.util.Comparator;

//Class where all the comparators of the application are located
public class HelperComparator {
    public static Comparator<User> userNameComparator(String order){
        return (u1,u2)-> {
            if ("name_asc".equals(order)) {
                return u1.getUserName().compareTo(u2.getUserName());
            } else if ("name_desc".equals(order)) {
                return u2.getUserName().compareTo(u1.getUserName());
            }
            return 0;
        };
    }

    public static Comparator<Post> postDateComparatorDescDefault(String order){
        return (p1,p2)-> {
            if ("date_asc".equals(order)) {
                return p1.getDate().compareTo(p2.getDate());
            } else {
                return p2.getDate().compareTo(p1.getDate());
            }
        };
    }
}
