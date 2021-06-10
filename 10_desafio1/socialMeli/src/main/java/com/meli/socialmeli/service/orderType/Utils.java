package com.meli.socialmeli.service.orderType;

import com.meli.socialmeli.exception.InvalidSortTypeException;

public class Utils {
    public static SortType getValidSortType(String order) throws InvalidSortTypeException {
        SortType sortType;
        try {
            sortType = SortType.valueOf(order);
        } catch (IllegalArgumentException e) {
            throw new InvalidSortTypeException(order);
        }
        return sortType;
    }
}
