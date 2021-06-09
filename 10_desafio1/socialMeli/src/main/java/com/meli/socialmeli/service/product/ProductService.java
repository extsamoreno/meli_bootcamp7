package com.meli.socialmeli.service.product;

import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.dto.product.FollowedPublicationDTO;
import com.meli.socialmeli.dto.product.PublicationDTO;
import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidDateFormatException;
import com.meli.socialmeli.repository.product.IProductRepository;
import com.meli.socialmeli.service.SocialMeliMapper;
import com.meli.socialmeli.service.UserOrderType;
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
        productRepository.save(SocialMeliMapper.toPublication(post));
    }

    @Override
    public FollowedPublicationDTO followedRecentPublications(Integer userId) throws IdNotFoundException {
        UserWithFollowedDTO user = userService.followedOf(userId, UserOrderType.name_asc);
        List<Integer> followedIds = user.getFollowed().stream().map(UserDTO::getUserId).collect(Collectors.toList());
        List<Publication> posts = getRecentsPublications(followedIds);
        orderListDesc(posts);
        return new FollowedPublicationDTO(user.getUserId(), SocialMeliMapper.toPublicationDTOList(posts));
    }

    private void orderListAsc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate));
    }

    private void orderListDesc(List<Publication> list) {
        list.sort(Comparator.comparing(Publication::getDate).reversed());
    }

    private List<Publication> getRecentsPublications(List<Integer> followedIds) {
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
