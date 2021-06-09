package com.meli.socialmeli.util;

import com.meli.socialmeli.dto.PostDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProductUtil {

    public static List<PostDTO> sortPosts(List<PostDTO> merchantPosts, String order) {
        if ("date_desc".equals(order)) {
            return sortPostsByDateDesc(merchantPosts);
        }
        return sortPostsByDateAsc(merchantPosts);
    }

    private static List<PostDTO> sortPostsByDateAsc(List<PostDTO> merchantPosts) {
        return merchantPosts.stream().sorted(
                Comparator.comparing(PostDTO::getDate)
        ).collect(Collectors.toList());
    }

    private static List<PostDTO> sortPostsByDateDesc(List<PostDTO> merchantPosts) {
        return merchantPosts.stream().sorted(
                Comparator.comparing(PostDTO::getDate).reversed()
        ).collect(Collectors.toList());
    }

    public static LocalDate toLocalDate(Date date) {
        return LocalDate.ofInstant(
                date.toInstant(), ZoneId.systemDefault());
    }

}
