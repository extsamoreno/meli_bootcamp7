package com.meli.socialmeli.service;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import com.meli.socialmeli.exception.InvalidDateFormatException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.List;
import java.util.stream.Collectors;


public class PublicationMapper {
    static String datePattern = "dd-MM-uuuu";
    static DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(datePattern);

    private static String parseDateToString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    private static LocalDate parseStringToDate(String date) throws InvalidDateFormatException {
        try {
            return LocalDate.parse(date, DATE_FORMATTER.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeException e) {
            throw new InvalidDateFormatException(date);
        }
    }

    public static Publication toPublication(PublicationDTO post) throws InvalidDateFormatException {
        return new Publication(
                post.getUserId(), post.getIdPost(), parseStringToDate(post.getDate()),
                post.getDetail(), post.getCategory(), post.getPrice(), false, 0);
    }

    public static List<PublicationDTO> toPublicationDTOList(List<Publication> list) {
        return list.stream().map(PublicationMapper::toPublicationDTO).collect(Collectors.toList());
    }

    public static PublicationDTO toPublicationDTO(Publication post) {
        return new PublicationDTO(
                post.getUserId(), post.getIdPost(), parseDateToString(post.getDate()),
                post.getDetail(), post.getCategory(), post.getPrice());
    }

    public static Publication promoToPublication(PublicationWithPromoDTO post) throws InvalidDateFormatException {
        Publication newPost = toPublication(post);
        newPost.setHasPromo(post.isHasPromo());
        newPost.setDiscount(post.getDiscount());
        return newPost;
    }

    public static List<PublicationWithPromoDTO> toPublicationWithPromoDTOList(List<Publication> list) {
        return list.stream().map(PublicationMapper::toPublicationWithPromoDTO).collect(Collectors.toList());
    }

    public static PublicationWithPromoDTO toPublicationWithPromoDTO(Publication post) {
        return new PublicationWithPromoDTO(
                post.getUserId(), post.getIdPost(), parseDateToString(post.getDate()),
                post.getDetail(), post.getCategory(), post.getPrice(), post.isHasPromo(), post.getDiscount());
    }
}
