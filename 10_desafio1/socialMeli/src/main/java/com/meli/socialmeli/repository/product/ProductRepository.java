package com.meli.socialmeli.repository.product;

import com.meli.socialmeli.domain.Product;
import com.meli.socialmeli.domain.Publication;
import com.meli.socialmeli.exception.CanNotCreatePostException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepository implements IProductRepository {

    public static List<Publication> postList = new ArrayList<>();

    @Override
    public void save(Publication post) throws CanNotCreatePostException {
        if (alreadyExists(post)) throw new CanNotCreatePostException(post.getIdPost());
        else this.create(post);
    }

    @Override
    public List<Publication> findByUserId(Integer userId) {
        return postList.stream().filter(p -> p.getUserId().equals(userId)).collect(Collectors.toList());
    }

    private void create(Publication post) {
        if (postList.isEmpty()) loadDatabase();
        postList.add(post);
    }

    private boolean alreadyExists(Publication post) {
        return postList.stream().anyMatch(x -> x.getIdPost().equals(post.getIdPost()));
    }

    private void loadDatabase() {
        //1569 6932 6631 1456 1578
        //Post created with id starting in 66
        LocalDate oldDate = LocalDate.now().minusWeeks(3);
        LocalDate recentDate = LocalDate.now().minusWeeks(1);
        LocalDate today = LocalDate.now();

        Publication u1569p1 = new Publication(1569, 660, oldDate, productSample(1569), 100, 23499.99);
        Publication u1569p2 = new Publication(1569, 661, recentDate, productSample(1569), 58, 12000);
        Publication u1569p3 = new Publication(1569, 662, today, productSample(1569), 150, 600);

        Publication u6932p1 = new Publication(6932, 663, oldDate, productSample(6932), 100, 999.99);
        Publication u6932p2 = new Publication(6932, 664, recentDate, productSample(6932), 58, 1245);
        Publication u6932p3 = new Publication(6932, 665, today, productSample(6932), 150, 6005);

        Publication u6631p1 = new Publication(6631, 666, oldDate, productSample(6631), 100, 4444);
        Publication u6631p2 = new Publication(6631, 667, recentDate, productSample(6631), 58, 5555);
        Publication u6631p3 = new Publication(6631, 668, today, productSample(6631), 150, 6666);

        Publication u1456p1 = new Publication(1456, 669, oldDate, productSample(1456), 100, 45647);
        Publication u1456p2 = new Publication(1456, 670, recentDate, productSample(1456), 58, 56469);
        Publication u1456p3 = new Publication(1456, 671, today, productSample(1456), 150, 6655);

        Publication u1578p1 = new Publication(1578, 672, oldDate, productSample(1578), 100, 4444);
        Publication u1578p2 = new Publication(1578, 673, recentDate, productSample(1578), 58, 5555);
        Publication u1578p3 = new Publication(1578, 674, today, productSample(1578), 150, 6666);
        postList.addAll(Arrays.asList(
                new Publication[]{u1569p1, u1569p2, u1569p3, u6932p1, u6932p2, u6932p3, u6631p1, u6631p2, u6631p3, u1456p1, u1456p2, u1456p3, u1578p1, u1578p2, u1578p3})
        );
    }

    private Product productSample(Integer userId) {
        return new Product(1, "A product From User:" + userId, "A type", "My brand", "Black Sabbath", "None");
    }

}
