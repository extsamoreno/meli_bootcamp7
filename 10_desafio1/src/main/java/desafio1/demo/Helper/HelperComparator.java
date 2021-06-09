package desafio1.demo.Helper;

import desafio1.demo.Model.Entity.User;

import java.util.Comparator;

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
}
