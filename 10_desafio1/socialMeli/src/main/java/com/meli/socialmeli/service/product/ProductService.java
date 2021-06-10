package com.meli.socialmeli.service.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import com.meli.socialmeli.dto.user.UserWithPromoCountDTO;
import com.meli.socialmeli.dto.user.UserWithPromoListDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.exception.InvalidSortTypeException;
import com.meli.socialmeli.repository.product.IProductRepository;
import com.meli.socialmeli.service.mapper.PublicationMapper;
import com.meli.socialmeli.service.orderType.SortType;
import com.meli.socialmeli.service.orderType.Utils;
import com.meli.socialmeli.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository productRepository;
    @Autowired
    IUserService userService;

    /**
     * map and send to persist a new publication
     *
     * @param post
     * @throws CanNotCreatePostException
     * @throws InvalidDateFormatException
     */
    @Override
    public void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException {
        productRepository.save(PublicationMapper.toPublication(post));
    }

    /**
     * maps and send to persist a new publication with promo
     *
     * @param post
     * @throws InvalidDateFormatException
     * @throws CanNotCreatePostException
     */
    @Override
    public void createPostWithPromo(PublicationWithPromoDTO post) throws InvalidDateFormatException, CanNotCreatePostException {
        productRepository.save(PublicationMapper.promoToPublication(post));
    }

    /**
     * returns a FollowedPublicationDTO with a list of recent publications of all the users that are followed by a specific userId
     * ordered by the received order criteria
     *
     * @param userId
     * @param order
     * @return
     * @throws IdNotFoundException
     * @throws InvalidSortTypeException
     */
    @Override
    public FollowedPublicationDTO followedRecentPublications(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException {
        User user = getUserByID(userId);
        List<Integer> followedIds = user.getFollowed().stream().map(User::getUserId).collect(Collectors.toList());
        List<Publication> posts = getRecentPublications(followedIds);
        sortByDate(posts, order);
        return new FollowedPublicationDTO(userId, PublicationMapper.toPublicationDTOList(posts));
    }

    /**
     * returns a UserWithPromoCountDTO with the publications quantity of a specific userId
     *
     * @param userId
     * @return
     * @throws IdNotFoundException
     */
    @Override
    public UserWithPromoCountDTO promoCountOf(Integer userId) throws IdNotFoundException {
        Integer count = publicationWithPromoOf(userId).size();
        User user = getUserByID(userId);
        return new UserWithPromoCountDTO(userId, user.getUserName(), count);
    }

    /**
     * returns a UserWithPromoListDTO with a list of PublicationWithPromoDTO of a specific userId
     *
     * @param userId
     * @param order
     * @return
     * @throws IdNotFoundException
     * @throws InvalidSortTypeException
     */
    @Override
    public UserWithPromoListDTO promoListOf(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException {
        User user = getUserByID(userId);
        List<Publication> posts = publicationWithPromoOf(userId);
        sortByDate(posts, order);
        return new UserWithPromoListDTO(userId, user.getUserName(), PublicationMapper.toPublicationWithPromoDTOList(posts));
    }

    /**
     * returns a user by id, connecting with an userService
     *
     * @param userId
     * @return
     * @throws IdNotFoundException
     */
    private User getUserByID(Integer userId) throws IdNotFoundException {
        return userService.getValidUserById(userId);
    }

    /**
     * returns a list of publication that has promo of a specific userId
     *
     * @param userId
     * @return
     */
    private List<Publication> publicationWithPromoOf(Integer userId) {
        return findPostByUserID(userId).stream().filter(Publication::isHasPromo).collect(Collectors.toList());
    }

    /**
     * sort a list of publication with a given criteria
     *
     * @param posts
     * @param order
     * @throws InvalidSortTypeException
     */
    private void sortByDate(List<Publication> posts, String order) throws InvalidSortTypeException {
        SortType sortType = Utils.getValidSortType(order);
        switch (sortType) {
            case date_asc:
                orderListAsc(posts);
                break;
            case date_desc:
                orderListDesc(posts);
                break;
            default:
                throw new InvalidSortTypeException(order);
        }
    }

    /**
     * sort a list of publication by ascending date
     *
     * @param list
     */
    private void orderListAsc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate));
    }

    /**
     * sort a list of publication by descending date
     *
     * @param list
     */
    private void orderListDesc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate).reversed());
    }

    /**
     * returns a list of all recent publications from multiples userId
     *
     * @param followedIds
     * @return
     */
    private List<Publication> getRecentPublications(List<Integer> followedIds) {
        List<Publication> temp = new ArrayList<>();
        followedIds.forEach(id -> temp.addAll(findRecentPostByUserID(id)));
        return temp;
    }

    /**
     * returns a list of all recent publications from a specific userId
     *
     * @param userId
     * @return
     */
    private List<Publication> findRecentPostByUserID(Integer userId) {
        return findPostByUserID(userId).stream().filter(p -> isRecent(p.getDate())).collect(Collectors.toList());
    }

    /**
     * defines the criteria of whether a publication is recent
     *
     * @param date
     * @return
     */
    private boolean isRecent(LocalDate date) {
        LocalDate limit = LocalDate.now().minusWeeks(2);
        return date.isAfter(limit);
    }

    /**
     * returns a list of all the publications of a specific userId
     *
     * @param userId
     * @return
     */
    private List<Publication> findPostByUserID(Integer userId) {
        return productRepository.findByUserId(userId);
    }
}
