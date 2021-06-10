package com.meli.socialmeli.service.orderType;

import com.meli.socialmeli.exception.InvalidSortTypeException;

public class Utils {
    /**
     * validates the received order it's one of the defined types
     *
     * @param order
     * @return
     * @throws InvalidSortTypeException
     */
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
