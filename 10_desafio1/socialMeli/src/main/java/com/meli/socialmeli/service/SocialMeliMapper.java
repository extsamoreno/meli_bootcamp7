package com.meli.socialmeli.service;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.InvalidDateFormatException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.stream.Collectors;


public class SocialMeliMapper {
    static String datePattern = "dd-MM-uuuu";
    static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(datePattern);

    public static UserWithFollowersCountDTO toFollowersCountDTO(User user) {
        Integer count = user.getFollowers().size();
        return new UserWithFollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }

    public static UserWithFollowersDTO toFollowersDTO(User user) {
        return new UserWithFollowersDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowers()));
    }

    public static UserWithFollowedDTO toFollowedDTO(User user) {
        return new UserWithFollowedDTO(user.getUserId(), user.getUserName(), toUserDTOList(user.getFollowed()));
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        return list.stream().map(SocialMeliMapper::toUserDTO).collect(Collectors.toList());
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static Publication toPublication(PublicationDTO post) throws InvalidDateFormatException {
        Publication newPost = new Publication();
        newPost.setUserId(post.getUserId());
        newPost.setId_post(post.getId_post());
        newPost.setDate(parseStringToDate(post.getDate()));
        newPost.setDetail(post.getDetail());
        newPost.setCategory(post.getCategory());
        newPost.setPrice(post.getPrice());
        return newPost;
    }

    private static LocalDate parseStringToDate(String date) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(date, DATE_FORMATTER.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeException e) {
            throw new InvalidDateFormatException(date);
        }
    }
}
