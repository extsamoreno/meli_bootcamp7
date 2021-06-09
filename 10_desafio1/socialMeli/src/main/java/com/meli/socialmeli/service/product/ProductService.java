package com.meli.socialmeli.service.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.product.PublicationWithPromoDTO;
import com.meli.socialmeli.dto.user.UserWithPromoCountDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.repository.product.IProductRepository;
import com.meli.socialmeli.service.PublicationMapper;
import com.meli.socialmeli.service.orderType.PublicationOrderType;
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

    @Override
    public void createPost(PublicationDTO post) throws CanNotCreatePostException, InvalidDateFormatException {
        productRepository.save(PublicationMapper.toPublication(post));
    }

    @Override
    public FollowedPublicationDTO followedRecentPublications(Integer userId, PublicationOrderType order) throws IdNotFoundException {
        User user = userService.getValidUserById(userId);
        List<Integer> followedIds = user.getFollowed().stream().map(User::getUserId).collect(Collectors.toList());
        List<Publication> posts = getRecentPublications(followedIds);

        if (order == null) return followedPublicationDTODesc(user.getUserId(), posts);
        return sortByDate(user.getUserId(), posts, order);
    }

    @Override
    public void createPostWithPromo(PublicationWithPromoDTO post) throws InvalidDateFormatException, CanNotCreatePostException {
        productRepository.save(PublicationMapper.promoToPublication(post));
    }

    @Override
    public UserWithPromoCountDTO promoCountOf(Integer userId) throws IdNotFoundException {
        Integer count = publicationWithPromoOf(userId).size();
        User user = userService.getValidUserById(userId);
        return new UserWithPromoCountDTO(userId, user.getUserName(), count);
    }

    private List<Publication> publicationWithPromoOf(Integer userId) {
        return findPostByUserID(userId).stream().filter(Publication::isHasPromo).collect(Collectors.toList());
    }

    private FollowedPublicationDTO sortByDate(Integer userId, List<Publication> posts, PublicationOrderType order) {
        if (order.equals(PublicationOrderType.date_desc)) return followedPublicationDTODesc(userId, posts);
        else if (order.equals(PublicationOrderType.date_asc)) return followedPublicationDTOAsc(userId, posts);
        else return new FollowedPublicationDTO(userId, PublicationMapper.toPublicationDTOList(posts));
    }


    private FollowedPublicationDTO followedPublicationDTOAsc(Integer userId, List<Publication> posts) {
        orderListAsc(posts);
        return new FollowedPublicationDTO(userId, PublicationMapper.toPublicationDTOList(posts));
    }

    private FollowedPublicationDTO followedPublicationDTODesc(Integer userId, List<Publication> posts) {
        orderListDesc(posts);
        return new FollowedPublicationDTO(userId, PublicationMapper.toPublicationDTOList(posts));
    }

    private void orderListAsc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate));
    }

    private void orderListDesc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate).reversed());
    }

    private List<Publication> getRecentPublications(List<Integer> followedIds) {
        List<Publication> temp = new ArrayList<>();
        followedIds.forEach(id -> temp.addAll(findRecentPostByUserID(id)));
        return temp;
    }

    private List<Publication> findRecentPostByUserID(Integer userId) {
        return findPostByUserID(userId).stream().filter(p -> isRecent(p.getDate())).collect(Collectors.toList());
    }

    private boolean isRecent(LocalDate date) {
        LocalDate limit = LocalDate.now().minusWeeks(2);
        return date.isAfter(limit);
    }

    private List<Publication> findPostByUserID(Integer userId) {
        return productRepository.findByUserId(userId);
    }
}
